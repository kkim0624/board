package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class ModiPostController
 */
@WebServlet("/modiPost")
public class ModiPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ModiPostController.class);
	
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postId = request.getParameter("postId");
		PostVo postVo = postService.getPost(postId);
		
		request.setAttribute("postVo", postVo);
		request.getRequestDispatcher("/user/modiPost.jsp").forward(request, response);
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		PostVo postVo = null;
		try {
			postVo = new PostVo(postId, userId, postTitle, postContent, sdf.parse(postWriteDate), postIsActive, parentId, boardId);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int updateCnt = postService.updatePost(postVo);
		
		response.sendRedirect(request.getContextPath()+"/showPost?postId="+postId);
		
	}

}
