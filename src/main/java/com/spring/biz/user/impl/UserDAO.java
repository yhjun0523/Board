package com.spring.biz.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.user.UserVO;

//DAO(Data Access Object)
@Repository("userDAO")
public class UserDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertUser(UserVO vo) {
		mybatis.insert("UserDAO.insertUser", vo);
	}

	public UserVO login(UserVO vo) {
		return (UserVO) mybatis.selectOne("UserDAO.login", vo);
	}
	
	public int idChk(UserVO vo) throws Exception {
		int result = mybatis.selectOne("UserDAO.idChk", vo);
		return result;
	}
}
