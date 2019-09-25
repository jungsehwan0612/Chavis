package com.chavis.biz.user.service;

import com.chavis.biz.user.vo.userVO;

public interface userService {
	userVO login(String client_id, String password);
	
	userVO getUser(String client_id);
}
