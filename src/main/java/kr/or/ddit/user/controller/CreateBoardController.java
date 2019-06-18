package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
 * Servlet implementation class userController
 */
@WebServlet("/createBoard")
public class CreateBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static final Logger logger = LoggerFactory
			.getLogger(CreateBoardController.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user/createBoard.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//	public BoardVo(String boardId, String userId, String boardNm,
		//	String boardIsActive, Date boardRegDate) {
		
		String boardNm = request.getParameter("boardNm");
		String boardIsActive = request.getParameter("boardIsActive");
		String userId = request.getParameter("userId");
		logger.debug("boardNm1 : {} ", boardNm);
		logger.debug("boardIsActive1 : {} ", boardIsActive);
		logger.debug("userId : {}", userId);
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNm(boardNm);
		boardVo.setboardIsActive(boardIsActive);
		boardVo.setUserId(userId);
		
		int insertCnt = boardService.insertBoard(boardVo);
		getServletContext().setAttribute("boardList", boardService.boardList()); 
		doGet(request, response); 
		
	}

}
