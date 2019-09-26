package com.chavis.biz.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.user.vo.userVO;

@Component("usermybatis")
public class userDAO_MyBatis implements userDAO{

	@Autowired
	SqlSession sqlSession = null;
	
	public userDAO_MyBatis() {
		System.out.println("userDAO_MyBatis 호출");
	}
	
	@Override
	public userVO login(String client_id, String password) {
		userVO vo = new userVO();
		vo.setClientId(client_id);
		vo.setPassword(password);
		
		return sqlSession.selectOne("userMapper.login", vo);
	}

	@Override
	public userVO getUser(String client_id) {
		return sqlSession.selectOne("userMapper.getuser", client_id);
	}

	@Override
	public List<userVO> getUserList() {
		return sqlSession.selectList("userMapper.listuser");
	}

	@Override
	public int addUser(userVO user) {
		return sqlSession.insert("userMapper.adduser", user);
	}

	@Override
	public int updateUser(userVO user) {
		return sqlSession.update("userMapper.updateuser", user);
	}

	@Override
	public int removeUser(String client_id) {
		return sqlSession.update("userMapper.removeuser", client_id);
	}
	
}
