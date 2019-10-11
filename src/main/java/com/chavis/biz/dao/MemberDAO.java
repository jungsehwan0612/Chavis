package com.chavis.biz.dao;

import java.util.List;
import java.util.Map;

import com.chavis.biz.vo.MemberVO;

public interface MemberDAO {
	MemberVO login(String member_id, String member_pw);

	MemberVO getMember(String member_id);
	
	List<MemberVO> getMemberList();
	
	int addMember(MemberVO member);
	
	int updateMember(Map<String, String> member);
	
	int removeMember(String member_id);
	
	List<MemberVO> selectMemberList(Map<String, Object> param);

	MemberVO dupcheck(String member_id);

	
}
