package com.chavis.biz.client.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.client.vo.ClientVO;

@Component("clientmybatis")
public class ClientDAO_MyBatis implements ClientDAO{

	@Autowired
	SqlSession sqlSession = null;
	
	public ClientDAO_MyBatis() {
		System.out.println("ClientDAO_MyBatis 호출");
	}
	
	public ClientVO login(String client_id, String password) {
		ClientVO vo = new ClientVO();
		vo.setClient_id(client_id);
		vo.setPassword(password);
		
		return sqlSession.selectOne("clientMapper.login", vo);
	}

	public ClientVO getClient(String client_id) {
		return sqlSession.selectOne("clientMapper.getclient", client_id);
	}

	public List<ClientVO> getClientList() {
		return sqlSession.selectList("clientMapper.listclient");
	}

	public int addClient(ClientVO client) {
		return sqlSession.insert("clientMapper.addclient", client);
	}

	public int updateClient(ClientVO client) {
		return sqlSession.update("clientMapper.updateclient", client);
	}

	public int removeClient(String client_id) {
		return sqlSession.update("clientMapper.removeclient", client_id);
	}

	@Override
	public List<ClientVO> selectClientList(Map<String, Object> param) {
		return sqlSession.selectList("clientMapper.selectClientList", param);
	}
	
}
