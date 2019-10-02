package com.chavis.biz.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.member.vo.MemberVO;

@Component("membermybatis")
public class MemberDAO_MyBatis implements MemberDAO{

	@Autowired
	SqlSession sqlSession = null;
	
	public MemberDAO_MyBatis() {
		System.out.println("MemberDAO_MyBatis 호출");
	}
	
	public MemberVO login(String Member_id, String member_pw) {
		MemberVO membervo = new MemberVO();
		membervo.setMember_id(Member_id);
		membervo.setMember_pw(member_pw);
		
		return sqlSession.selectOne("MemberMapper.login", membervo);
	}

	public MemberVO getMember(String member_id) {
		return sqlSession.selectOne("MemberMapper.getMember", member_id);
	}

	public List<MemberVO> getMemberList() {
		return sqlSession.selectList("MemberMapper.listMember");
	}

	public int addMember(MemberVO member) {
		return sqlSession.insert("MemberMapper.addMember", member);
	}

	public int updateMember(MemberVO member) {
		return sqlSession.update("MemberMapper.updateMember", member);
	}

	public int removeMember(MemberVO member_id) {
		return sqlSession.update("MemberMapper.removeMember", member_id);
	}

	@Override
	public List<MemberVO> selectMemberList(Map<String, Object> param) {
		return sqlSession.selectList("MemberMapper.selectMemberList", param);
	}
	
}
