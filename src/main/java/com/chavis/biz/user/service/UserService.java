package com.chavis.biz.user.service;

import java.util.List;

import com.chavis.biz.user.vo.userVO;

public interface userService {
	userVO login(String client_id, String password);
	
	userVO getUser(String client_id);
	
	int addUser(userVO user);
	
	int updateUser(userVO user);
	
	int removeUser(String client_id);
	
	List<userVO> getUserList();
}
