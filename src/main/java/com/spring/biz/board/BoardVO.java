package com.spring.biz.board;

public class BoardVO {
	// 게시글 타입
	private String boardType;

	private String boardType_a01;

	private String boardType_a02;

	private String boardType_a03;

	private String boardType_a04;

	// 게시글 번호
	private int boardNum;

	// 게시글 제목
	private String boardTitle;

	// 게시글 내용
	private String boardComment;

	// 생성자
	private String creator;

	// 생성시간
	private String creatorTime;

	// 수정자
	private String modifier;

	// 수정시간
	private String modifiedTime;

	// 파일
	private String fileRoot;

	private int pageNum = 1; // 페이지 번호
	private int amount = 10; // 일반 게시판 페이지당 데이터 갯수

	// 게시판 타입명
	private String codeName;

	public String getBoardType_a01() {
		return boardType_a01;
	}

	public void setBoardType_a01(String boardType_a01) {
		this.boardType_a01 = boardType_a01;
	}

	public String getBoardType_a02() {
		return boardType_a02;
	}

	public void setBoardType_a02(String boardType_a02) {
		this.boardType_a02 = boardType_a02;
	}

	public String getBoardType_a03() {
		return boardType_a03;
	}

	public void setBoardType_a03(String boardType_a03) {
		this.boardType_a03 = boardType_a03;
	}

	public String getBoardType_a04() {
		return boardType_a04;
	}

	public void setBoardType_a04(String boardType_a04) {
		this.boardType_a04 = boardType_a04;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardComment() {
		return boardComment;
	}

	public void setBoardComment(String boardComment) {
		this.boardComment = boardComment;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatorTime() {
		return creatorTime;
	}

	public void setCreatorTime(String creatorTime) {
		this.creatorTime = creatorTime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getFileRoot() {
		return fileRoot;
	}

	public void setFileRoot(String fileRoot) {
		this.fileRoot = fileRoot;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCodeName() {
		return codeName;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	@Override
	public String toString() {
		return "BoardVO [boardType=" + boardType + ", boardType_a01=" + boardType_a01 + ", boardType_a02="
				+ boardType_a02 + ", boardType_a03=" + boardType_a03 + ", boardType_a04=" + boardType_a04
				+ ", boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardComment=" + boardComment
				+ ", creator=" + creator + ", creatorTime=" + creatorTime + ", modifier=" + modifier + ", modifiedTime="
				+ modifiedTime + ", fileRoot=" + fileRoot + ", pageNum=" + pageNum + ", amount=" + amount
				+ ", codeName=" + codeName + "]";
	}

}
