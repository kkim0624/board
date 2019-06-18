package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;

public class BoardDaoImpl implements IBoardDao{

	@Override
	public List<BoardVo> boardList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.boardList");
		sqlSession.close();
		return boardList;
	}
	
	@Override
	public BoardVo getBoard(String boardId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BoardVo boardVo = sqlSession.selectOne("board.getUser", boardId);
		sqlSession.close();
		return boardVo;
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("board.insertBoard",boardVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteBoard(String boardId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("board.deleteBoard", boardId);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}
	
	@Override
	public int modifyBoard(BoardVo boardVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("board.modifyBoard", boardVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public List<BoardVo> boardPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.boardPagingList",pageVo);
		sqlSession.close();
		return boardList;
	}

	@Override
	public int boardCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int boardCnt = (Integer) sqlSession.selectOne("board.boardCnt");
		sqlSession.close();
		return boardCnt;
	}



	
	
	

}
