package kr.or.ddit.post;

import static org.junit.Assert.*;
import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.login.loginController;
import kr.or.ddit.post.dao.IPostDao;
import kr.or.ddit.post.dao.PostDaoImpl;
import kr.or.ddit.post.model.PostVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(PostDaoTest.class);
	
	private IPostDao postDao;
	
	@Before
	public void setup(){
		postDao = new PostDaoImpl();
	}
	
	/**
	 * 
	* Method : getPostTest
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시글 조회 테스트
	 */
	@Test
	public void getPostTest() {
		/***Given***/
		String postId = "1";	
		/***When***/
		PostVo postVo = postDao.getPost(postId);
		/***Then***/
		assertEquals("테스트1", postVo.getPostTitle());
	}
	
	@Test
	public void insertPostTest(){
		/***Given***/
		
		/***When***/

		/***Then***/
	}
	
}
