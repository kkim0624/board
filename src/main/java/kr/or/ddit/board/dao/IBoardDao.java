package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.paging.model.PageVo;

public interface IBoardDao {
	
	/**
	 * 
	* Method : boardList
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 조회
	 */
	List<BoardVo> boardList();
			
	/**
	 * 
	* Method : getBoard
	* 작성자 : PC04
	* 변경이력 :
	* @param boardId
	* @return
	* Method 설명 : 게시판 정보 조회
	 */
	BoardVo getBoard(String boardId);
	
	/**
	 * 
	* Method : insertBoard
	* 작성자 : PC04
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 등록
	 */
	int insertBoard(BoardVo boardVo);
	
	/**
	 * 
	* Method : deleteBoard
	* 작성자 : PC04
	* 변경이력 :
	* @param boardId
	* @return
	* Method 설명 : 게시판 삭제
	 */
	int deleteBoard(String boardId);
	
	/**
	 * 
	* Method : modifyBoard
	* 작성자 : PC04
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 수정
	 */
	int modifyBoard(BoardVo boardVo);
	
	/**
	 * 
	* Method : boardPagingList
	* 작성자 : PC04
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 게시판 페이징 리스트 조회
	 */
	List<BoardVo> boardPagingList(PageVo pageVo);
	
	/**
	 * 
	* Method : usersCnt
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체수 조회
	 */
	int boardCnt();
	
}
