package com.spring.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.CommonVO;

@Repository("boardDAO")
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD 기능
	// insert 기능
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	// update
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
		System.out.println(vo.getBoardTitle());
	}

	// delete
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	// 개별보기
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	// 목록보기
	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
	
	// 페이징
	public int totalCnt(BoardVO vo) {
        return mybatis.selectOne("BoardDAO.getTotalCnt", vo);
    }
	
	public int searchTotalCnt(BoardVO vo) {
        return mybatis.selectOne("BoardDAO.getSearchTotalCnt", vo);
    }
	
	public List<CommonVO> getMenuList(CommonVO com) {
		return mybatis.selectList("BoardDAO.getMenuList", com);
	}
	
	public List<CommonVO> getPhoneList(CommonVO com) {
		return mybatis.selectList("BoardDAO.getPhoneList", com);
	}
	
	public List<BoardVO> getSearchList(BoardVO vo) {
		return mybatis.selectList("BoardDAO.getSearchList", vo);
	}

}
