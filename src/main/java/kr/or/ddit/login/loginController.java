package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.encrypt.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(loginController.class);
	
	private IUserService userService;
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
		boardService = new BoardServiceImpl();
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("USER_INFO")==null){
			request.getRequestDispatcher("login/login.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().setAttribute("boardList", boardService.boardList()); ///////////////// 환석 20190608-1655
//		request.setAttribute("boardList", boardService.boardList());
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String encryptPassword = KISA_SHA256.encrypt(password);
		
		logger.debug("useId : {} ", userId);
		logger.debug("password : {} ", password);
		
		UserVo userVo = userService.getUser(userId);
		logger.debug("userVo : {} ", userVo);
		
		if(userVo != null && encryptPassword.equals(userVo.getPass())){
			
			request.getSession().setAttribute("USER_INFO", userVo);
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			
		}else{
			
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
		
	}

}
