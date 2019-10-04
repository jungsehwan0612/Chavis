package com.chavis.biz.service;


import java.util.List;

import com.chavis.biz.vo.BodyshopVO;

public interface BodyshopService {
	BodyshopVO bodyshopLogin(String bodyshop_id,String bodyshop_pw);
	void addBodyshop(BodyshopVO vo);
	void updateBodyshopPassword(String pw);
	void removeBodyshop(String bodyshop_id, String bodyshop_pw);
	List<BodyshopVO> searchBodyshop(String bodyshop_address, String bodyshop_name);
	List<BodyshopVO> getBodyshoplist();

}