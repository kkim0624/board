package kr.or.ddit.post.dao;

import java.util.List;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.post.model.PostVo;

public interface IPostDao {
	
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
	
	/**
	 * 
	* Method : deletePost
	* 작성자 : PC04
	* 변경이력 :
	* @param postId
	* @return
	* Method 설명 : 게시글 삭제
	 */
	int deletePost(String postId);
	
	/**
	 * 
	* Method : updatePost
	* 작성자 : PC04
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 수정
	 */
	int updatePost(PostVo postVo);
	
	/**
	 * 
	* Method : postPagingList
	* 작성자 : PC04
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 게시글 페이징 리스트 조회
	 */
	List<PostVo> postPagingList (PageVo pageVo);
	
	/**
	 * 
	* Method : postCnt
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 전체수 조회
	 */
	int postCnt();
}
