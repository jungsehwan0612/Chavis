package com.chavis.biz.carbodyshop.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.chavis.biz.carbodyshop.dao.CarBodyshopDAO;
import com.chavis.biz.carbodyshop.vo.CarBodyshopVO;
import com.chavis.biz.client.dao.ClientDAO;
import com.chavis.biz.client.vo.ClientVO;

@Service("carbodyservice")
public class CarBodyshopServiceImpl implements CarBodyshopService {
	
	@Resource(name = "carbodyshopmybatis")
	CarBodyshopDAO dao;

	@Autowired
	ApplicationContext context;

	public CarBodyshopServiceImpl() {
		System.out.println("CarBodyshopServiceImpl 호출");
	}

	public CarBodyshopServiceImpl(CarBodyshopDAO dao) {
		this.dao = dao;
	}

	public CarBodyshopDAO getDao() {
		return dao;
	}

	public void setDao(CarBodyshopDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public CarBodyshopVO bodylogin(String body_id, String body_pw) {
		String msg = "";
		CarBodyshopVO vo = null;
		try {
			vo = dao.bodylogin(body_id, body_pw);

			if (vo != null) {
				msg = context.getMessage("login.success", new Object[] { body_id }, Locale.KOREA);
			} else {
				msg = context.getMessage("login.fail", new Object[] { body_id }, Locale.KOREA);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(msg);
		return vo;
	}
	

	@Override
	public CarBodyshopVO getBody(String body_id) {
		return dao.getBody(body_id);
	}

	@Override
	public List<CarBodyshopVO> getCarBodyshopList() {
		return dao.getCarBodyshopList();
	}

	@Override
	public List<CarBodyshopVO> selectCarBodyshopList(Map<String, Object> param) {
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
		
		return dao.selectCarBodyshopList(param);
	}

	@Override
	public int addCarBodyshop(CarBodyshopVO body) {
		return dao.addCarBodyshop(body);
	}

	@Override
	public int updateCarBodyshop(CarBodyshopVO body) {
		return dao.updateCarBodyshop(body);
	}

	@Override
	public int removeCarBodyshop(CarBodyshopVO body_id) {
		return dao.removeCarBodyshop(body_id);
	}

	
}
