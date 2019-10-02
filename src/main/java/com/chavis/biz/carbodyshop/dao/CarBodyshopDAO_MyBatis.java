package com.chavis.biz.carbodyshop.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.carbodyshop.vo.CarBodyshopVO;

@Component("carbodyshopmybatis")
public class CarBodyshopDAO_MyBatis implements CarBodyshopDAO {
	@Autowired
    SqlSession sqlSession = null;

	@Override
	public CarBodyshopVO bodyLogin(String bodyshop_id, String bodyshop_pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("CarBodyshop_bodyLogin");
		map.put("bodyshop_id", bodyshop_id);
		map.put("bodyshop_pw", bodyshop_pw);
		return sqlSession.selectOne("carbodyshop.bodyLogin", map);
	}

	@Override
	public void addBodyshop(CarBodyshopVO vo) {
		System.out.println("CarBodyshop_addBodyshop");
		sqlSession.insert("carbodyshop.addBodyshop", vo);
		sqlSession.commit();
	}

	@Override
	public void updateBodyshop(CarBodyshopVO vo, String bodyshop_id) {
		System.out.println("CarBodyshop_updateBodyshop");
		sqlSession.update("carbodyshop.updateBodyshop");
		sqlSession.commit();
	}

	@Override
	public void removeBodyshop(String bodyshop_id, String bodyshop_pw) {
		System.out.println("CarBodyshop_removeBodyshop");
		sqlSession.delete("carbodyshop.removeBodyshop");
		sqlSession.commit();
	}

	@Override
	public CarBodyshopVO searchBodyshop(String bodyshop_address, String bodyshop_name) {
		return null;
	}

	@Override
	public List<CarBodyshopVO> getCarBodyshoplist() {
		return null;
	}

    
}
