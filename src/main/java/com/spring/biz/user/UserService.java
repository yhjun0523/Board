package com.spring.biz.user;

public interface UserService {
	void insertUser(UserVO vo);

	UserVO login(UserVO vo);
	
	int idChk(UserVO vo) throws Exception;
}
