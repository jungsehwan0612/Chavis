package com.chavis.biz.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mybatis")
public class userDAO_MyBatis implements userDAO{

	@Autowired
	SqlSession sqlSession = null;
	
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
	
}
