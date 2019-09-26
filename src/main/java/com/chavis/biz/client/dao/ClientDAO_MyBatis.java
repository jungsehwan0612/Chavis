package com.chavis.biz.client.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.client.vo.ClientVO;

@Component("usermybatis")
public class ClientDAO_MyBatis implements ClientDAO{

	@Autowired
	SqlSession sqlSession = null;
	
	public ClientDAO_MyBatis() {
		System.out.println("ClientDAO_MyBatis 호출");
	}
	
	public ClientVO login(String client_id, String password) {
		ClientVO vo = new ClientVO();
		vo.setClientId(client_id);
		vo.setPassword(password);
		
		return sqlSession.selectOne("userMapper.login", vo);
	}

	public ClientVO getClient(String client_id) {
		return sqlSession.selectOne("userMapper.getuser", client_id);
	}

	public List<ClientVO> getClientList() {
		return sqlSession.selectList("userMapper.listuser");
	}

	public int addClient(ClientVO user) {
		return sqlSession.insert("userMapper.adduser", user);
	}

	public int updateClient(ClientVO user) {
		return sqlSession.update("userMapper.updateuser", user);
	}

	public int removeClient(String client_id) {
		return sqlSession.update("userMapper.removeuser", client_id);
	}
	
}
