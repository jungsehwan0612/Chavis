package com.chavis.biz.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.chavis.biz.connect.ConnectDB;
import com.chavis.biz.dao.MemberDAO;
import com.chavis.biz.vo.MemberVO;
import com.chavis.biz.vo.ReservationVO;

// service 객체를 만들기 위한 class
public class MemberService {
	public MemberVO login(String id, String pw) {
		Connection con = null;
		MemberVO vo = null;
		try {
			con = ConnectDB.getConnection();
			MemberDAO dao = new MemberDAO(con);
			vo = dao.login(id, pw);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return vo;
	}

	public List<ReservationVO> getMemberList(String keyword) {
		Connection con = null;
		List<ReservationVO> list = null;
		try {
			con = ConnectDB.getConnection();
			MemberDAO dao = new MemberDAO(con);
			list = dao.getMemberList(keyword);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return list;
	}

	public boolean register(MemberVO vo) {
		Connection con = null;
		boolean flag = false;
		try {
			con = ConnectDB.getConnection();
			MemberDAO dao = new MemberDAO(con);
			flag = dao.register(vo);
			if (flag == true) {
				con.commit();
			} else {
				con.rollback();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return flag;
	}

}
