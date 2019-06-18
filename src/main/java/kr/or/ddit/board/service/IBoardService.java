package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.paging.model.PageVo;

public interface IBoardService {
	
	/**
	 * 
	* Method : boardList
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 리스트 조회
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
	* @param boardList
	* @return
	* Method 설명 : 게시판 등록
	 */
	int insertBoard(BoardVo boardVo);
	
	int deleteBoard(String boardId);
	
	int modifyBoard(BoardVo boardVo);
	
	Map<String, Object> boardPagingList(PageVo pageVo);
	
}
