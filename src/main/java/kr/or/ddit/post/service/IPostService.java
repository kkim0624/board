package kr.or.ddit.post.service;

import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.post.model.PostVo;

public interface IPostService {
	
	/**
	 * 
	* Method : getPost
	* 작성자 : PC04
	* 변경이력 :
	* @param postId
	* @return
	* Method 설명 : 게시글 정보 조회
	 */
	PostVo getPost(String postId);
	
	/**
	 * 
	* Method : insertPost
	* 작성자 : PC04
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 등록
	 */
	int insertPost(PostVo postVo);
	
	int deletePost(String postId);
	
	int updatePost(PostVo postVo);
	
	Map<String, Object> postPagingList(PageVo pageVo);
}
