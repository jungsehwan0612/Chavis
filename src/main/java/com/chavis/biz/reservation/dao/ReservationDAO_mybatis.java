package com.chavis.biz.reservation.dao;

import java.util.List;

import com.chavis.biz.reservation.vo.ReservationVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("reservationmybatis")
public class ReservationDAO_mybatis implements ReservationDAO {

    @Autowired
    SqlSession sqlSession = null;

    @Override
    public int addReservation(ReservationVO reservation) {
        return sqlSession.insert("reserveMapper.addReserve",reservation);
    }

    @Override
    public ReservationVO getReservation(int reservation_no) {
        return sqlSession.selectOne("reserveMapper.getReserve", reservation_no);
    }

    @Override
    public List<ReservationVO> getReservationToday() {
        return sqlSession.selectList("reserveMapper.listReserve");
    }
    
    @Override
	public List<ReservationVO> getReservationWeek() {
    	return sqlSession.selectList("reserveMapper.listReserve");
	}

    @Override
    public int updateReservation(ReservationVO reservation) {
        return sqlSession.update("reserveMapper.updateReserve", reservation);
    }

    @Override
    public int removeReservation(int reserve_no) {
        return sqlSession.delete("reserveMapper.removeReserve", reserve_no);
    }
}