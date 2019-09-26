package com.chavis.biz.user.dao;

import java.util.List;

import com.chavis.biz.user.vo.ClientVO;

public interface ClientDAO {
	ClientVO login(String client_id, String password);

	ClientVO getClient(String client_id);
	
	List<ClientVO> getClientList();
	
	int addClient(ClientVO user);
	
	int updateClient(ClientVO user);
	
	int removeClient(String client_id);
}
