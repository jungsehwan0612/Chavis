package com.chavis.biz.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.user.vo.ClientVO;

@Component("usermybatis")
public class ClientDAO_MyBatis implements ClientDAO{

	@Autowired
	SqlSession sqlSession = null;
	
	public ClientDAO_MyBatis() {
		System.out.println("ClientDAO_MyBatis 호출");
	}
	
	@Override
	public ClientVO login(String client_id, String password) {
		ClientVO vo = new ClientVO();
		vo.setClientId(client_id);
		vo.setPassword(password);
		
		return sqlSession.selectOne("userMapper.login", vo);
	}

	@Override
	public ClientVO getClient(String client_id) {
		return sqlSession.selectOne("userMapper.getuser", client_id);
	}

	@Override
	public List<ClientVO> getClientList() {
		return sqlSession.selectList("userMapper.listuser");
	}

	@Override
	public int addClient(ClientVO user) {
		return sqlSession.insert("userMapper.adduser", user);
	}

	@Override
	public int updateClient(ClientVO user) {
		return sqlSession.update("userMapper.updateuser", user);
	}

	@Override
	public int removeClient(String client_id) {
		return sqlSession.update("userMapper.removeuser", client_id);
	}
	
}
