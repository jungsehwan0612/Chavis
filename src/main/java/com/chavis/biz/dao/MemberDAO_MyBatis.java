package com.chavis.biz.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.vo.MemberVO;
import com.chavis.biz.vo.ReservationVO;

@Component("membermybatis")
public class MemberDAO_MyBatis implements MemberDAO{

	@Autowired
	SqlSession sqlSession;
	
	public MemberDAO_MyBatis() {
		System.out.println("MemberDAO 시작");
	}
	
	public MemberVO dupcheck(String Member_id) {
		MemberVO membervo = new MemberVO();
		membervo.setMember_id(Member_id);
		
		return sqlSession.selectOne("memberMapper.dupcheck", membervo);
	}
	
	public MemberVO login(String Member_id, String member_pw) {
		MemberVO membervo = new MemberVO();
		membervo.setMember_id(Member_id);
		membervo.setMember_pw(member_pw);
		
		return sqlSession.selectOne("memberMapper.memberLogin", membervo);
	}

	public MemberVO getMember(String member_id) {
		return sqlSession.selectOne("memberMapper.getMember", member_id);
	}

	public List<MemberVO> getMemberList() {
		return sqlSession.selectList("memberMapper.listMember");
	}

	public int addMember(MemberVO member) {
		return sqlSession.insert("memberMapper.addMember", member);
	}

	public int updateCar(Map<String, String> member) {
		System.out.println("daocar" + member);
		return sqlSession.update("memberMapper.updateCar", member);
	}
	
	public int removeMember(String member_id) {
		return sqlSession.update("memberMapper.removeMember", member_id);
	}

	@Override
	public List<MemberVO> selectMemberList(Map<String, Object> param) {
		int startIndex = 1;
		int endIndex = 20;
		if(param.containsKey("pageSize") && param.containsKey("pageIndex")) {
			int pageSize = (int) param.get("pageSize"); 
			int pageIndex = (int) param.get("pageIndex");
			
			startIndex = pageSize * (pageIndex - 1) + 1;
			endIndex = startIndex + pageSize;
		} 
		param.put("startIndex", startIndex);
		param.put("lastIndex", endIndex);
		return sqlSession.selectList("memberMapper.selectMemberList", param);
	}

	public List<ReservationVO> getMemberReserveList(String id){
		return sqlSession.selectList("memberMapper.getMemberReserveList", id);
	}
	
	@Override
	public int updateMember(Map<String, String> member) {
		System.out.println("daoupdatemember" + member);
		return sqlSession.update("memberMapper.updateMember", member);
	}
}
