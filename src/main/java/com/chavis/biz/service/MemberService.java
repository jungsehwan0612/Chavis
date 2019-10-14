package com.chavis.biz.service;

import java.util.List;
import java.util.Map;

import com.chavis.biz.vo.MemberVO;

public interface MemberService {
	MemberVO login(String member_id, String member_pw);
	
	MemberVO getMember(String member_id);
	
	int addMember(MemberVO member);
	
	int updateMember(Map<String, String> map1);
	
	int updateCar(Map<String, String> map2);
	
	int removeMember(String string);
	
	List<MemberVO> getMemberList();
	
	List<MemberVO> selectMemberList(Map<String, Object> param);

	int dupcheck(String member_id);
}
