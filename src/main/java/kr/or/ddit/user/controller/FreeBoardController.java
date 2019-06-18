package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.crypto.spec.OAEPParameterSpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
 * Servlet implementation class FreeBoardController
 */
@WebServlet("/board")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class FreeBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static final Logger logger = LoggerFactory
			.getLogger(FreeBoardController.class);
	
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		logger.debug("page : {}", page);
		logger.debug("pageSize : {}", pageSize);
		
		PageVo pageVo = new PageVo(page, pageSize);
				
		postService.postPagingList(pageVo);
		logger.debug("요놈",postService.postPagingList(pageVo));
		
		Map<String, Object> resultMap = postService.postPagingList(pageVo);
		List<PostVo> postList = (List<PostVo>) resultMap.get("postList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		logger.debug("resultMap : {}", resultMap);
		logger.debug("postList : {}", postList);
		logger.debug("paginationSize : {}", paginationSize);
		
		request.setAttribute("postPagingList", postList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("/user/freeBoard.jsp").forward(request, response);
		
	}

}
