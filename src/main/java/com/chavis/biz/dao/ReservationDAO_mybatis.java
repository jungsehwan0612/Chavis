package com.chavis.biz.reservation.dao;

import java.util.List;

import com.chavis.biz.reservation.vo.ReservationVO;
import com.chavis.biz.vo.ReservationListVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("reservationmybatis")
public class ReservationDAO_mybatis implements ReservationDAO {

    @Autowired
    SqlSession sqlSession = null;

    @Override
    public int addReservation(ReservationVO reservation) {
        return sqlSession.insert("reservationMapper.addReservation",reservation);

    }

    @Override
    public ReservationVO getReservation(int reservation_no) {

        return sqlSession.selectOne("reservationMapper.getReservation", reservation_no);

    }

    @Override
    public List<ReservationVO> getReservationToday() {

        return sqlSession.selectList("reservationMapper.listReservation");

    }

    
    public List<ReservationVO> getReservationWeek() {
    	return sqlSession.selectList("reserveMapper.listReservation");
	}


    @Override
    public int updateReservation(ReservationVO reservation) {
        return sqlSession.update("reservationMapper.updateReservation", reservation);

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
		return sqlSession.selectList("reserveMapper.getReservationList");
	}
}
