package com.chavis.biz.dao;

import java.util.List;

import com.chavis.biz.vo.BodyshopVO;
import com.chavis.biz.vo.ReservationListVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bodyshopmybatis")
public class BodyshopDAO_MyBatis implements BodyshopDAO {
	@Autowired
	SqlSession sqlSession;

	public BodyshopDAO_MyBatis() {
		System.out.println("BodyshopDAO 시작");
	}

	@Override
	public BodyshopVO bodyshopLogin(String bodyshop_id, String bodyshop_pw) {
		System.out.println("BODYSHOP LOGIN");
		BodyshopVO bodyshop = new BodyshopVO();
		bodyshop.setBodyshop_id(bodyshop_id);
		bodyshop.setBodyshop_pw(bodyshop_pw);
		return sqlSession.selectOne("bodyshopMapper.bodyshopLogin", bodyshop);
	}

	@Override
	public void addBodyshop(BodyshopVO bodyshop) {
		System.out.println("ADD BODYSHOP");
		sqlSession.insert("bodyshopMapper.addBodyshop", bodyshop);
	}

	@Override
	public List<BodyshopVO> getBodyshoplist() {
		System.out.println("GET BODYSHOP LIST");
		return sqlSession.selectList("bodyshopMapper.getBodyshoplist");
	}

	@Override
	public List<ReservationListVO> getReservationList(int id) {
		return sqlSession.selectList("reservationMapper.getReservationList", id);
	}

	@Override
	public int getNo() {
		return sqlSession.selectOne("bodyshopMapper.getNo");
	}

}
