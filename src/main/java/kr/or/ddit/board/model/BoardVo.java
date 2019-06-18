package kr.or.ddit.board.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVo {
	
	private String boardId; // 게시판 아이디
	private String userId; // 게시판 생성자
	private String boardNm; // 게시판 이름
	private String boardIsActive; // 게시판 사용여부
	private Date boardRegDate; // 게시판 생성일시
	
	public BoardVo() {

	}
	
	public BoardVo(String boardId, String userId, String boardNm,
			String boardIsActive, Date boardRegDate) {
		super();
		this.boardId = boardId;
		this.userId = userId;
		this.boardNm = boardNm;
		this.boardIsActive = boardIsActive;
		this.boardRegDate = boardRegDate;
	}

	public BoardVo(String boardNm, String boardIsActive) {
		this.boardNm = boardNm;
		this.boardIsActive = boardIsActive;
	}

	@Override
	public String toString() {
		return "BoardVo [boardId=" + boardId + ", userId=" + userId
				+ ", boardNm=" + boardNm + ", boardIsActive=" + boardIsActive
				+ ", boardRegDate=" + boardRegDate + "]";
	}

	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardNm() {
		return boardNm;
	}
	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}
	public String getboardIsActive() {
		return boardIsActive;
	}
	public void setboardIsActive(String boardIsActive) {
		this.boardIsActive = boardIsActive;
	}
	public Date getBoardRegDate() {
		return boardRegDate;
	}
	public String getBoardRegDateStr(){ // 2019-06-05
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(this.boardRegDate);
	}
	public void setBoardRegDate(Date boardRegDate) {
		this.boardRegDate = boardRegDate;
	}
	
}

