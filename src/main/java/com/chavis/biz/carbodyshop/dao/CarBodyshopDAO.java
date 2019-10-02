package com.chavis.biz.carbodyshop.dao;


import java.util.List;

import com.chavis.biz.carbodyshop.vo.CarBodyshopVO;

public interface CarBodyshopDAO {
	CarBodyshopVO bodyLogin(String bodyshop_id,String bodyshop_pw);
	void addBodyshop(CarBodyshopVO vo);
	void updateBodyshop(CarBodyshopVO vo, String bodyshop_id);
	void removeBodyshop(String bodyshop_id, String bodyshop_pw);
	CarBodyshopVO searchBodyshop(String bodyshop_address, String bodyshop_name);
	List<CarBodyshopVO> getCarBodyshoplist();

}
