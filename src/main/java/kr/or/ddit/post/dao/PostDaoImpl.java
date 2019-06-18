package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.post.model.PostVo;

public class PostDaoImpl implements IPostDao{

	@Override
	public PostVo getPost(String postId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		PostVo postVo = sqlSession.selectOne("post.getPost",postId);
		sqlSession.close();
		return postVo;
	}

	@Override
	public int insertPost(PostVo postVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("post.insertPost");
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deletePost(String postId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("post.deletePost", postId);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int updatePost(PostVo postVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("post.updatePost", postVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public List<PostVo> postPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<PostVo> postList = sqlSession.selectList("post.postPagingList",pageVo);
		sqlSession.close();
		return postList;
	}

	@Override
	public int postCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int postCnt = (Integer) sqlSession.selectOne("post.postCnt");
		sqlSession.close();
		return postCnt;
	}



}
