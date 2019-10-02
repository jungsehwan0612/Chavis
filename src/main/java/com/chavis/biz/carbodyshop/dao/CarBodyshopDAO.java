package com.chavis.biz.carbodyshop.dao;

import java.util.List;
import java.util.Map;

import com.chavis.biz.carbodyshop.vo.CarBodyshopVO;

public interface CarBodyshopDAO {
	CarBodyshopVO bodylogin(String body_id,String body_pw);
	
	CarBodyshopVO getBody(String body_id);
	
	List<CarBodyshopVO> getCarBodyshopList();
	
	List<CarBodyshopVO> selectCarBodyshopList(Map<String, Object> param);
	
	int addCarBodyshop(CarBodyshopVO body);
	
	int updateCarBodyshop(CarBodyshopVO body);
	
	int removeCarBodyshop(CarBodyshopVO body_id);
}
