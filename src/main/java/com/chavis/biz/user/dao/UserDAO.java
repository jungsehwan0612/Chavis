package com.chavis.biz.user.dao;

import java.util.List;

import com.chavis.biz.user.vo.UserVO;

public interface UserDAO {
	UserVO login(String client_id, String password);

	UserVO getUser(String client_id);
	
	List<UserVO> getUserList();
	
	int addUser(UserVO user);
	
	int updateUser(UserVO user);
	
	int removeUser(String client_id);	
}
