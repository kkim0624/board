package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ietf.jgss.Oid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;

/**
 * Servlet implementation class ShowPostController
 */
@WebServlet("/showPost")
public class ShowPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(ShowPostController.class);
	
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("userContoroller doGet");
				
		String postId = request.getParameter("postId");
		
		PostVo postVo = postService.getPost(postId);
		logger.debug("postVo : {}", postVo);
		
		request.setAttribute("postVo", postVo);
		
		request.getRequestDispatcher("/user/showPost.jsp").forward(request, response);
		
		
		
	}

}
