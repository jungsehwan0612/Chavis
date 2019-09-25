package com.chavis.biz.user.dao;

import com.chavis.biz.user.vo.userVO;

public interface userDAO {
	userVO login(String client_id, String password);

	userVO getUser(String client_id);
}
