package com.chavis.biz.user.service;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.chavis.biz.user.dao.ClientDAO;
import com.chavis.biz.user.vo.ClientVO;

@Service("userservice")
public class ClientServiceImpl implements ClientService {

	@Resource(name="usermybatis")
	ClientDAO dao;
	
	@Autowired
	ApplicationContext context;
	
	public ClientServiceImpl() {
		System.out.println("userServiceImpl 호출");
	}
	public ClientServiceImpl(ClientDAO dao) {
		this.dao = dao;
	}
	public ClientDAO getDao() {
		return dao;
	}
	public void setDao(ClientDAO dao) {
		this.dao = dao;
	}
	@Override
	public ClientVO login(String client_id, String password) {
		String msg = "";
		ClientVO vo = null;
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
	public ClientVO getClient(String client_id) {
		return dao.getClient(client_id);
	}
	@Override
	public int addClient(ClientVO user) {
		return dao.addClient(user);
	}
	@Override
	public int updateClient(ClientVO user) {
		return dao.updateClient(user);
	}
	@Override
	public int removeClient(String client_id) {
		return dao.removeClient(client_id);
	}
	@Override
	public List<ClientVO> getClientList() {
		return dao.getClientList();
	}
	
	
}
