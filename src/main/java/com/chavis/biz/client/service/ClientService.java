package com.chavis.biz.client.service;

import java.util.List;
import java.util.Map;

import com.chavis.biz.client.vo.ClientVO;

public interface ClientService {
	ClientVO login(String client_id, String password);
	
	ClientVO getClient(String client_id);
	
	int addClient(ClientVO user);
	
	int updateClient(ClientVO user);
	
	int removeClient(String client_id);
	
	List<ClientVO> getClientList();
	
	List<ClientVO> selectClientList(Map<String, Object> param);
}
