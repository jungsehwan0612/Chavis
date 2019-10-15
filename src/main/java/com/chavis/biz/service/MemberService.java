package com.chavis.biz.service;

import java.util.List;
import java.util.Map;

import com.chavis.biz.vo.MemberVO;
import com.chavis.biz.vo.NotificationVO;
import com.chavis.biz.vo.ReservationVO;

public interface MemberService {
	MemberVO login(String member_id, String member_pw);

	int addMember(MemberVO member);

	int updateMember(Map<String, String> map1);

	int updateCar(Map<String, String> map2);

	int dupcheck(String member_id);

	List<NotificationVO> getNotificationList(String member_id);

	List<ReservationVO> getMemberReserveList(String id);
}
