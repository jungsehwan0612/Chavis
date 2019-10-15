package com.chavis.biz.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chavis.biz.vo.ReservationListVO;
import com.chavis.biz.vo.ReservationVO;
import com.chavis.biz.vo.WebTableVO;

@Component("reservationmybatis")
public class ReservationDAO_MyBatis implements ReservationDAO {

	@Autowired
	SqlSession sqlSession;

	public ReservationDAO_MyBatis() {
		System.out.println("ReservationDAO 시작");
	}

	@Override
	public int addReservation(Map<String, String> reservation) {
		return sqlSession.insert("reservationMapper.addReservation", reservation);
	}

	@Override
	public ReservationVO getReservation(int reservation_no) {

		return sqlSession.selectOne("reservationMapper.getReservation", reservation_no);

	}

	@Override
	public List<ReservationVO> getReservationByBodyshopNo(int bodyshop_no) {
		return sqlSession.selectList("reservationMapper.getReservationByBodyshopNo", bodyshop_no);
	}

	@Override
	public List<WebTableVO> getReservationForWeb(int bodyshop_no) {
		return sqlSession.selectList("reservationMapper.getReservationForWeb");
	}

	@Override
	public int updateReservation(ReservationVO reservation) {
		reservation.setReservation_no(reservation.getBodyshop_no());
		reservation.setRepaired_time(reservation.getRepaired_time());
		reservation.setRepaired_person(reservation.getRepaired_person());
		return sqlSession.insert("reserveMapper.updateReservation", reservation);
	}

	@Override

	public int removeReservation(int reservation_no) {
		return sqlSession.delete("reservationMapper.removeReservation", reservation_no);

	}

	@Override
	public List<ReservationVO> getReservationByID(String member_id) {
		return sqlSession.selectList("reservationMapper.listReservationByID", member_id);
	}

	@Override
	public List<ReservationListVO> getReservationList(String id) {
		return sqlSession.selectList("reservationMapper.getReservationList", id);
	}

	@Override
	public int finishRepair(int reservation_no, String repaired_time, String repaired_person) {
		System.out.println("reservationDAO");
		ReservationVO vo = new ReservationVO();
		vo.setReservation_no(reservation_no);
		vo.setRepaired_time(repaired_time);
		vo.setRepaired_person(repaired_person);
		System.out.println("vo" + vo.getReservation_no());
		System.out.println("vo" + vo.getRepaired_time());
		System.out.println("vo" + vo.getRepaired_person());
		System.out.println(vo.toString());
		return sqlSession.update("reservationMapper.finishRepair", vo);
	}
}
