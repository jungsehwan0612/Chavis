package com.chavis.biz.user.service;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.chavis.biz.user.dao.userDAO;
import com.chavis.biz.user.vo.userVO;

@Service("userservice")
public class userServiceImpl implements userService {

	@Resource(name="usermybatis")
	userDAO dao;
	
	@Autowired
	ApplicationContext context;
	
	public userServiceImpl() {
		System.out.println("userServiceImpl 호출");
	}
	public userServiceImpl(userDAO dao) {
		this.dao = dao;
	}
	public userDAO getDao() {
		return dao;
	}
	public void setDao(userDAO dao) {
		this.dao = dao;
	}
	@Override
	public userVO login(String client_id, String password) {
		String msg = "";
		userVO vo = null;
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
	public userVO getUser(String client_id) {
		return dao.getUser(client_id);
	}
	@Override
	public int addUser(userVO user) {
		return dao.addUser(user);
	}
	@Override
	public int updateUser(userVO user) {
		return dao.updateUser(user);
	}
	@Override
	public int removeUser(String client_id) {
		return dao.removeUser(client_id);
	}
	@Override
	public List<userVO> getUserList() {
		return dao.getUserList();
	}
	
	
}
