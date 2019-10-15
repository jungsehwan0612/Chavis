package com.chavis.biz.dao;

import com.chavis.biz.vo.CarVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carmybatis")
public class CarDAO_MyBatis implements CarDAO {

	@Autowired
	SqlSession sqlSession;

	public CarDAO_MyBatis() {
		System.out.println("CarDAO 시작");
	}

	@Override
	public CarVO getPersonalCar(String member_id) {
		return sqlSession.selectOne("carMapper.getPersonalCar", member_id);
	}
}
