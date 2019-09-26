package com.chavis.biz.user.service;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.chavis.biz.user.dao.UserDAO;
import com.chavis.biz.user.vo.UserVO;

@Service("userservice")
public class UserServiceImpl implements UserService {

	@Resource(name="usermybatis")
	UserDAO dao;
	
	@Autowired
	ApplicationContext context;
	
	public UserServiceImpl() {
		System.out.println("userServiceImpl 호출");
	}
	public UserServiceImpl(UserDAO dao) {
		this.dao = dao;
	}
	public UserDAO getDao() {
		return dao;
	}
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	@Override
	public UserVO login(String client_id, String password) {
		String msg = "";
		UserVO vo = null;
		try {
			vo = dao.login(client_id, password);
			
			if (vo != null) {
				msg = context.getMessage("login.success", new Object[] { vo.getClientName() }, Locale.KOREA);
			} else {
				msg = context.getMessage("login.fail", new Object[] { client_id }, Locale.KOREA);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(msg);
		return vo;
	}

	@Override
	public UserVO getUser(String client_id) {
		return dao.getUser(client_id);
	}
	@Override
	public int addUser(UserVO user) {
		return dao.addUser(user);
	}
	@Override
	public int updateUser(UserVO user) {
		return dao.updateUser(user);
	}
	@Override
	public int removeUser(String client_id) {
		return dao.removeUser(client_id);
	}
	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}	
}
