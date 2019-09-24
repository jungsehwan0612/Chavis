package com.chavis.biz.user;

public interface userDAO {
	userVO login(String client_id, String password);

	userVO getUser(String client_id);
}
