package com.chavis.biz.member.service;

import java.util.List;
import java.util.Map;

import com.chavis.biz.member.vo.MemberVO;

public interface MemberService {
	MemberVO login(String member_id, String member_pw);
	
	MemberVO getMember(String member_id);
	
	int addMember(MemberVO member);
	
	int updateMember(MemberVO member);
	
	int removeMember(String string);
	
	List<MemberVO> getMemberList();
	
	List<MemberVO> selectMemberList(Map<String, Object> param);
}
