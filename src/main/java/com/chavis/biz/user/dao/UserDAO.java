package com.chavis.biz.user.dao;

import java.util.List;

import com.chavis.biz.user.vo.userVO;

public interface userDAO {
	userVO login(String client_id, String password);

	userVO getUser(String client_id);
	
	List<userVO> getUserList();
	
	int addUser(userVO user);
	
	int updateUser(userVO user);
	
	int removeUser(String client_id);	
}
