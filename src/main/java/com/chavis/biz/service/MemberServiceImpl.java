package com.chavis.biz.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import com.chavis.biz.dao.MemberDAO;
import com.chavis.biz.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service("memberservice")
public class MemberServiceImpl implements MemberService {

	@Resource(name = "membermybatis")
	MemberDAO dao;

	@Autowired
	ApplicationContext context;

	public MemberServiceImpl() {
		System.out.println("MemberService 시작");
	}

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	public MemberVO login(String member_id, String password) {
		String msg = "";
		MemberVO vo = null;
		try {
			vo = dao.login(member_id, password);

			if (vo != null) {
				msg = context.getMessage("login.success", new Object[] { vo.getMember_mname() }, Locale.KOREA);
			} else {
				msg = context.getMessage("login.fail", new Object[] { member_id }, Locale.KOREA);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(msg);
		return vo;
	}

	public MemberVO getMember(String member_id) {
		return dao.getMember(member_id);
	}

	public int addMember(MemberVO member) {
		return dao.addMember(member);
	}

	public int updateMember(MemberVO member) {
		return dao.updateMember(member);
	}

	public int removeMember(String member_id) {
		return dao.removeMember(member_id);
	}

	public List<MemberVO> getMemberList() {
		return dao.getMemberList();
	}

	public List<MemberVO> selectMemberList(Map<String, Object> param) {		
		return dao.selectMemberList(param);
	}
	
}
