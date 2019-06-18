package kr.or.ddit.post.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class PostVo {
	
	private String postId; // 게시글 아이디
	private String userId; // 게시글 작성자
	private String postTitle; // 게시글 제목
	private String postContent; // 게시글 내용
	private Date postWriteDate; // 게시글 작성일시
	private String postIsActive; // 게시글 사용여부
	private String parentId; // 부모 게시글 아이디
	private String boardId; // 게시판 아이디

	public PostVo() {

	}

	public PostVo(String postId, String userId, String postTitle,
			String postContent, Date postWriteDate, String postIsActive,
			String parentId, String boardId) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postWriteDate = postWriteDate;
		this.postIsActive = postIsActive;
		this.parentId = parentId;
		this.boardId = boardId;
	}

	@Override
	public String toString() {
		return "PostVo [postId=" + postId + ", userId=" + userId
				+ ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postWriteDate=" + postWriteDate + ", postIsActive="
				+ postIsActive + ", parentId=" + parentId + ", boardId="
				+ boardId + "]";
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getPostWriteDate() {
		return postWriteDate;
	}

	public String getPostWriteDateStr(){ // 2019-06-05
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(this.postWriteDate);
	}
	
	public void setPostWriteDate(Date postWriteDate) {
		this.postWriteDate = postWriteDate;
	}

	public String getPostIsActive() {
		return postIsActive;
	}

	public void setPostIsActive(String postIsActive) {
		this.postIsActive = postIsActive;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	
}


