package com.chavis.biz.carbodyshop.dao;


import java.util.List;

import com.chavis.biz.carbodyshop.vo.CarBodyshopVO;

public interface CarBodyshopDAO {
	CarBodyshopVO bodyLogin(String bodyshop_id,String bodyshop_pw);
	void addBodyshop(CarBodyshopVO vo);
	void updateBodyshopPassword(String pw);
	void removeBodyshop(String bodyshop_id, String bodyshop_pw);
	List<CarBodyshopVO> searchBodyshop(String bodyshop_address, String bodyshop_name);
	List<CarBodyshopVO> getBodyshoplist();

}
