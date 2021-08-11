package com.spring.biz.board;

import java.util.List;

public interface BoardService {
	// 글 등록
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);

	// 글 목록 조회
	List<BoardVO> getBoardList(BoardVO vo);
	
	// 글 개수
	int totalCnt(BoardVO vo);
	
	// 글 개수
	int searchTotalCnt(BoardVO vo);
	
	// 메뉴 불러오기
	List<CommonVO> getMenuList(CommonVO vo);
	
	// 번호 불러오기
	List<CommonVO> getPhoneList(CommonVO vo);
	
	// 검색
	List<BoardVO> getSearchList(BoardVO vo);
}
