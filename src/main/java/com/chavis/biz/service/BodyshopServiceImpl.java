package com.chavis.biz.service;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.chavis.biz.dao.BodyshopDAO;
import com.chavis.biz.vo.BodyshopVO;
import com.chavis.biz.vo.ReservationListVO;

@Service("bodyshopservice")
public class BodyshopServiceImpl implements BodyshopService {

	@Resource(name = "bodyshopmybatis")
	BodyshopDAO dao;

	@Autowired
	ApplicationContext context;

	public BodyshopServiceImpl() {
		System.out.println("BodyshopService 시작");
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
	public List<BodyshopVO> getBodyshoplist() {
		return dao.getBodyshoplist();
	}

	@Override
	public List<ReservationListVO> getReservationList(int member_no) {
		return dao.getReservationList(member_no);
	}

	@Override
	public int getNo() {
		return dao.getNo();
	}

}
