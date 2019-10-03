package com.chavis.biz.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.chavis.biz.connect.ConnectDB;
import com.chavis.biz.dao.*;
import com.chavis.biz.vo.*;

// service 객체를 만들기 위한 class
public class BodyshopService {

	public BodyShopVO bodyshoplogin(String id, String pw) {
		Connection con = null;
		BodyShopVO vo = null;
		try {
			con = ConnectDB.getConnection();
			ReservationDAO dao = new ReservationDAO(con);
			vo = dao.bodyshoplogin(id, pw);
			if (vo == null) {
				BodyShopVO temp = new BodyShopVO();
				temp.setBodyshop_id("NO");
				return temp;
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
		return vo;
	}

	public List<ReservationListVO> getReserveList(String id) {
		Connection con = null;
		List<ReservationListVO> list = null;
		try {
			con = ConnectDB.getConnection();
			ReservationDAO dao = new ReservationDAO(con);
			list = dao.getReserveList(id);
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
}
