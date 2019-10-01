package com.chavis.biz.client.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.chavis.biz.client.dao.ClientDAO;
import com.chavis.biz.client.vo.ClientVO;

@Service("clientservice")
public class ClientServiceImpl implements ClientService {

	@Resource(name = "clientmybatis")
	ClientDAO dao;

	@Autowired
	ApplicationContext context;

	public ClientServiceImpl() {
		System.out.println("clientServiceImpl 호출");
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

	public ClientVO login(String client_id, String password) {
		String msg = "";
		ClientVO vo = null;
		try {
			vo = dao.login(client_id, password);

			if (vo != null) {
				msg = context.getMessage("login.success", new Object[] { vo.getClient_name() }, Locale.KOREA);
			} else {
				msg = context.getMessage("login.fail", new Object[] { client_id }, Locale.KOREA);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(msg);
		return vo;
	}

	public ClientVO getClient(String client_id) {
		return dao.getClient(client_id);
	}

	public int addClient(ClientVO client) {
		return dao.addClient(client);
	}

	public int updateClient(ClientVO client) {
		return dao.updateClient(client);
	}

	public int removeClient(ClientVO client_id) {
		return dao.removeClient(client_id);
	}

	public List<ClientVO> getClientList() {
		return dao.getClientList();
	}

	public List<ClientVO> selectClientList(Map<String, Object> param) {
		int startIndex = 1;
		int endIndex = 20;
		if(param.containsKey("pageSize") && param.containsKey("pageIndex")) {
			int pageSize = (int) param.get("pageSize"); 
			int pageIndex = (int) param.get("pageIndex");
			
			startIndex = pageSize * (pageIndex - 1) + 1;
			endIndex = startIndex + pageSize;
		} 
		param.put("startIndex", startIndex);
		param.put("lastIndex", endIndex);
		
		return dao.selectClientList(param);
	}
	
}
