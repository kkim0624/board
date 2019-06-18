package kr.or.ddit.board;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardServiceTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BoardServiceTest.class);

	private IBoardService boardService;
	
	@Before
	public void setup(){
		boardService = new BoardServiceImpl();
	}
	
	/**
	 * 
	* Method : boardList
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 리스트 조회
	 */
	@Test
	public void boardListTest(){
		/***Given***/
		/***When***/
		List<BoardVo> userList = boardService.boardList();
		/***Then***/
		assertEquals(11, userList.size());
		
	}
	
	/**
	 * 
	* Method : getBoardTest
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시판 조회 테스트
	 */
	@Test 
	public void getBoardTest(){
		/***Given***/
		String boardId = "test1";
		/***When***/
		BoardVo boardVo = boardService.getBoard(boardId);
		/***Then***/
		assertEquals("Q&A게시판", boardVo.getBoardNm());
	}
	
	@Test
	public void insertBoardTest(){
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		BoardVo boardVo = null;
		
		try {
			boardVo = new BoardVo("test0610", "bumwhi", "게시판 생성 테스트", "N", sdf.parse("2019-06-10"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/***When***/
		int insertCnt = boardService.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
		boardService.deleteBoard(boardVo.getBoardId());
	}
	
}
