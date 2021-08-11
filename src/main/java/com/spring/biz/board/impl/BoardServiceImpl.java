package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.board.CommonVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	public BoardServiceImpl() {
	}

	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

	public int totalCnt(BoardVO vo) {
		return boardDAO.totalCnt(vo);
	}
	
	public int searchTotalCnt(BoardVO vo) {
		return boardDAO.searchTotalCnt(vo);
	}


	public List<CommonVO> getMenuList(CommonVO com) {
		return boardDAO.getMenuList(com);
	}
	
	public List<CommonVO> getPhoneList(CommonVO com) {
		return boardDAO.getPhoneList(com);
	}

	public List<BoardVO> getSearchList(BoardVO vo) {
		return boardDAO.getSearchList(vo);
	}

}
