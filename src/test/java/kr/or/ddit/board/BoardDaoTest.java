package kr.or.ddit.board;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.user.dao.UserDaoImpl;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BoardDaoTest.class);
	
	private IBoardDao boardDao;
	
	@Before
	public void setup(){
		boardDao = new BoardDaoImpl();
		logger.debug("setup");
	}
	
	/**
	 * 
	* Method : boardListTest
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시판 전체 조회 테스트
	 */
	@Test
	public void boardListTest() {
		/***Given***/

		/***When***/
		List<BoardVo> boardList = boardDao.boardList();
		
		/***Then***/
		assertEquals(33, boardList.size());
		logger.debug("boardList : {}", boardList);
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
		BoardVo boardVo = boardDao.getBoard(boardId);
		/***Then***/
		assertEquals("Q&A게시판", boardVo.getBoardNm());
	}
	
	/**
	 * 
	* Method : insertBoardTest
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시판 등록 테스트
	 */
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
		int insertCnt = boardDao.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
		
		boardDao.deleteBoard(boardVo.getBoardId());
	}

}
