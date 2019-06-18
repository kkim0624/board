package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class RegPostController
 */
@WebServlet("/regPost")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class RegPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(RegPostController.class);
	
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/SE2/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String postId = request.getParameter("postId");
		String userId = request.getParameter("userId");
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent"); 
		String postWriteDate = request.getParameter("postWriteDate");
		String postIsActive = request.getParameter("postIsActive");
		String parentId = request.getParameter("parentId");
		String boardId = request.getParameter("boardId");
		
		logger.debug("postId : {} ", postId);
		logger.debug("postTitle : {} ", postTitle);
		logger.debug("postContent : {} ", postContent);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		PostVo postVo = null; 
		try {
			postVo = new PostVo(postId, userId, postTitle, postContent, sdf.parse(postWriteDate), postIsActive, parentId, boardId);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		logger.debug("postVo : {}", postVo);
		
		PostVo dbPost = postService.getPost(postId);
		
		if(dbPost == null){
			int insertCnt = postService.insertPost(postVo);
		}else{
			doGet(request, response);
		}
		
		
	}

}
