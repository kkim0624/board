package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.post.dao.IPostDao;
import kr.or.ddit.post.dao.PostDaoImpl;
import kr.or.ddit.post.model.PostVo;

public class PostServiceImpl implements IPostService{
	
	private IPostDao postDao;
	
	public PostServiceImpl() {
		postDao = new PostDaoImpl();
	}

	@Override
	public PostVo getPost(String postId) {
		return postDao.getPost(postId);
	}

	@Override
	public int insertPost(PostVo postVo) {
		return postDao.insertPost(postVo);
	}

	@Override
	public int deletePost(String postId) {
		return postDao.deletePost(postId);
	}
	
	@Override
	public int updatePost(PostVo postVo) {
		return postDao.updatePost(postVo);
	}

	@Override
	public Map<String, Object> postPagingList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("postList", postDao.postPagingList(pageVo));
		
		int postCnt = postDao.postCnt();
		
		int paginationSize = (int)Math.ceil((double)postCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}


	
}
