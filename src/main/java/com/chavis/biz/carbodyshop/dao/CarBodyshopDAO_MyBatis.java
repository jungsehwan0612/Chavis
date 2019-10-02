package com.chavis.biz.carbodyshop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.carbodyshop.vo.CarBodyshopVO;
import com.chavis.biz.client.vo.ClientVO;
import com.chavis.biz.reservation.vo.ReservationVO;

@Component("carbodyshopmybatis")
public class CarBodyshopDAO_MyBatis implements CarBodyshopDAO {
	@Autowired
    SqlSession sqlSession = null;

	@Override
	public CarBodyshopVO bodylogin(String bodyshop_id, String bodyshop_pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("bodyshop_id", bodyshop_id);
		map.put("bodyshop_pw", bodyshop_pw);
		return sqlSession.selectOne("carbodyshop.bodylogin", map);
	}

//	@Override
//	public CarBodyshopVO getBody(String body_id) {
//		return sqlSession.selectOne("carbodyshop.getbody", body_id);
//	}
//
//	@Override
//	public List<CarBodyshopVO> getCarBodyshopList() {
//		return sqlSession.selectList("carbodyshop.listbody");
//	}
//
//	@Override
//	public List<CarBodyshopVO> selectCarBodyshopList(Map<String, Object> param) {
//		return sqlSession.selectList("carbodyshop.selectList", param);
//	}
//
//	@Override
//	public int addCarBodyshop(CarBodyshopVO body) {
//		return sqlSession.insert("carbodyshop.addbody", body);
//	}
//
//	@Override
//	public int updateCarBodyshop(CarBodyshopVO body) {
//		return sqlSession.update("carbodyshop.updatebody", body);
//	}
//
//	@Override
//	public int removeCarBodyshop(CarBodyshopVO body_id) {
//		return sqlSession.update("carbodyshop.removebody", body_id);
//	}

    
}
