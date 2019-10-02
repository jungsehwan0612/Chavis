package com.chavis.biz.reservation.service;

import java.util.List;

import javax.annotation.Resource;

import com.chavis.biz.reservation.dao.ReservationDAO;
import com.chavis.biz.reservation.vo.ReservationVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service("reservationservice")
public class ReservationServiceImpl implements ReservationService {

    @Resource(name = "reservationmybatis")
    ReservationDAO dao;
    
    @Autowired
    ApplicationContext context;


    public ReservationServiceImpl(ReservationDAO dao)   {
        this.dao = dao;
    }

    @Override
    public int addReservation(ReservationVO reservation) {
        return dao.addReservation(reservation);
    }

    @Override
    public ReservationVO getReservation(int reservation_no) {
        return dao.getReservation(reservation_no);
    }

    @Override
    public List<ReservationVO> getReservationToday() {
        return dao.getReservationToday();
    }

    @Override
    public int updateReservation(ReservationVO reservation) {
        return dao.updateReservation(reservation);
    }

    @Override
    public int removeReservation(int reserve_no) {
        return dao.removeReservation(reserve_no);
    }

	@Override
	public List<ReservationVO> getReservationByID(String member_id) {
		return dao.getReservationByID(member_id);
	}

}
