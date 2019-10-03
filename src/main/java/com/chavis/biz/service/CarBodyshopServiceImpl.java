package com.chavis.biz.carbodyshop.service;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.chavis.biz.carbodyshop.dao.CarBodyshopDAO;
import com.chavis.biz.carbodyshop.vo.CarBodyshopVO;

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
	public CarBodyshopVO bodyLogin(String bodyshop_id, String bodyshop_pw) {
		String msg = "";
		CarBodyshopVO vo = null;
		try {
			vo = dao.bodyLogin(bodyshop_id, bodyshop_pw);

			if (vo != null) {
				msg = context.getMessage("login.success", new Object[] { bodyshop_id }, Locale.KOREA);
			} else {
				msg = context.getMessage("login.fail", new Object[] { bodyshop_id }, Locale.KOREA);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(msg);
		return vo;
	}

	@Override
	public void addBodyshop(CarBodyshopVO vo) {
		dao.addBodyshop(vo);
	}

	@Override
	public void updateBodyshopPassword(String pw) {
		dao.updateBodyshopPassword(pw);
	}

	@Override
	public void removeBodyshop(String bodyshop_id, String bodyshop_pw) {
		dao.removeBodyshop(bodyshop_id, bodyshop_pw);
	}

	@Override
	public List<CarBodyshopVO> searchBodyshop(String bodyshop_address, String bodyshop_name) {
		return dao.searchBodyshop(bodyshop_address, bodyshop_name);
	}

	@Override
	public List<CarBodyshopVO> getBodyshoplist() {
		return dao.getBodyshoplist();
	}

	
}
