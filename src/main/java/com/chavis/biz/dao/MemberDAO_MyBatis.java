package com.chavis.biz.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.vo.MemberVO;
import com.chavis.biz.vo.NotificationVO;
import com.chavis.biz.vo.ReservationVO;

@Component("membermybatis")
public class MemberDAO_MyBatis implements MemberDAO {

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

	public int addMember(MemberVO member) {
		return sqlSession.insert("memberMapper.addMember", member);
	}

	public int updateCar(Map<String, String> member) {
		System.out.println("daocar" + member);
		return sqlSession.update("memberMapper.updateCar", member);
	}

	public List<NotificationVO> getNotificationList(String member_id) {
		return sqlSession.selectList("memberMapper.getNotificationList", member_id);
	}

	public List<ReservationVO> getMemberReserveList(String id) {
		System.out.println(id);
		return sqlSession.selectList("memberMapper.getMemberReserveList", id);
	}

	public int updateMember(Map<String, String> member) {
		System.out.println("daoupdatemember" + member);
		return sqlSession.update("memberMapper.updateMember", member);
	}
}
