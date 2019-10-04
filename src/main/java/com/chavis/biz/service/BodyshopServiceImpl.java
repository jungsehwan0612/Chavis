package com.chavis.biz.service;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import com.chavis.biz.dao.BodyshopDAO;
import com.chavis.biz.vo.BodyshopVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@Service("bodyshopservice")
public class BodyshopServiceImpl implements BodyshopService {
	
	@Resource(name = "bodyshopmybatis")
	BodyshopDAO dao;

	@Autowired
	ApplicationContext context;

	public BodyshopServiceImpl() {
		System.out.println("CarBodyshopServiceImpl 호출");
	}

	public BodyshopServiceImpl(BodyshopDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public BodyshopVO bodyshopLogin(String bodyshop_id, String bodyshop_pw) {
		String msg = "";
		BodyshopVO vo = null;
		try {
			vo = dao.bodyshopLogin(bodyshop_id, bodyshop_pw);

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
	public void addBodyshop(BodyshopVO vo) {
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
	public List<BodyshopVO> searchBodyshop(String bodyshop_address, String bodyshop_name) {
		return dao.searchBodyshop(bodyshop_address, bodyshop_name);
	}

	@Override
	public List<BodyshopVO> getBodyshoplist() {
		return dao.getBodyshoplist();
	}

	
}
