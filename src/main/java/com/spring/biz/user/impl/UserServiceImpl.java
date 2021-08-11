package com.spring.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}
	
	@Override
	public UserVO login(UserVO vo) {
		return userDAO.login(vo);
	}
	
	@Override
	public int idChk(UserVO vo) throws Exception {
		int result = userDAO.idChk(vo);
		return result;
	}
}
