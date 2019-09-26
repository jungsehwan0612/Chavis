package com.chavis.biz.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.user.vo.UserVO;

@Component("usermybatis")
public class UserDAO_MyBatis implements UserDAO{

	@Autowired
	SqlSession sqlSession = null;
	
	public UserDAO_MyBatis() {
		System.out.println("userDAO_MyBatis 호출");
	}
	
	@Override
	public UserVO login(String client_id, String password) {
		UserVO vo = new UserVO();
		vo.setClientId(client_id);
		vo.setPassword(password);
		
		return sqlSession.selectOne("userMapper.login", vo);
	}

	@Override
	public UserVO getUser(String client_id) {
		return sqlSession.selectOne("userMapper.getuser", client_id);
	}

	@Override
	public List<UserVO> getUserList() {
		return sqlSession.selectList("userMapper.listuser");
	}

	@Override
	public int addUser(UserVO user) {
		return sqlSession.insert("userMapper.adduser", user);
	}

	@Override
	public int updateUser(UserVO user) {
		return sqlSession.update("userMapper.updateuser", user);
	}

	@Override
	public int removeUser(String client_id) {
		return sqlSession.update("userMapper.removeuser", client_id);
	}
	
}
