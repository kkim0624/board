package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.paging.model.PageVo;

public class BoardServiceImpl implements IBoardService{

	private IBoardDao boardDao;
	
	public BoardServiceImpl(){
		boardDao = new BoardDaoImpl();
	}
	
	@Override
	public List<BoardVo> boardList() {
		return boardDao.boardList();
	}
	
	@Override
	public BoardVo getBoard(String boardId) {
		return boardDao.getBoard(boardId);
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	@Override
	public int deleteBoard(String boardId) {
		return boardDao.deleteBoard(boardId);
	}
	
	@Override
	public int modifyBoard(BoardVo boardVo) {
		return boardDao.modifyBoard(boardVo);
	}

	@Override
	public Map<String, Object> boardPagingList(PageVo pageVo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("boardList", boardDao.boardPagingList(pageVo));
		
		int boardCnt = boardDao.boardCnt();
		
		int paginationSize = (int) Math.ceil((double) boardCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}





	
}
