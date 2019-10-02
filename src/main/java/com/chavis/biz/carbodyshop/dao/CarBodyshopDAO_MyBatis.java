package com.chavis.biz.carbodyshop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.carbodyshop.vo.CarBodyshopVO;
import com.chavis.biz.client.vo.ClientVO;
import com.chavis.biz.reserve.vo.ReserveVO;

@Component("carbodyshopmybatis")
public class CarBodyshopDAO_MyBatis implements CarBodyshopDAO {
	@Autowired
    SqlSession sqlSession = null;

	@Override
	public CarBodyshopVO bodylogin(String body_id, String body_pw) {
		CarBodyshopVO vo = new CarBodyshopVO();
		vo.setBody_id(body_id);
		vo.setBody_pw(body_pw);
		
		return sqlSession.selectOne("carbodyshopMapper.bodylogin", vo);
	}

	@Override
	public CarBodyshopVO getBody(String body_id) {
		return sqlSession.selectOne("carbodyshopMapper.getbody", body_id);
	}

	@Override
	public List<CarBodyshopVO> getCarBodyshopList() {
		return sqlSession.selectList("carbodyshopMapper.listbody");
	}

	@Override
	public List<CarBodyshopVO> selectCarBodyshopList(Map<String, Object> param) {
		return sqlSession.selectList("carbodyshopMapper.selectList", param);
	}

	@Override
	public int addCarBodyshop(CarBodyshopVO body) {
		return sqlSession.insert("carbodyshopMapper.addbody", body);
	}

	@Override
	public int updateCarBodyshop(CarBodyshopVO body) {
		return sqlSession.update("carbodyshopMapper.updatebody", body);
	}

	@Override
	public int removeCarBodyshop(CarBodyshopVO body_id) {
		return sqlSession.update("carbodyshopMapper.removebody", body_id);
	}

    
}
