package com.chavis.biz.dao;

import java.util.List;

import com.chavis.biz.vo.BodyshopVO;
import com.chavis.biz.vo.ReservationListVO;

public interface BodyshopDAO {
	BodyshopVO bodyshopLogin(String bodyshop_id, String bodyshop_pw);

	int getNo();

	void addBodyshop(BodyshopVO vo);

	void updateBodyshopPassword(String pw);

	void removeBodyshop(String bodyshop_id, String bodyshop_pw);

	List<BodyshopVO> searchBodyshop(String bodyshop_address, String bodyshop_name);

	List<BodyshopVO> getBodyshoplist();

	List<ReservationListVO> getReservationList(int member_no);
}
