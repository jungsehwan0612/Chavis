package com.chavis.biz.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.chavis.biz.dao.ReservationDAO;
import com.chavis.biz.vo.ReservationVO;

@Service("reservationservice")
public class ReservationServiceImpl implements ReservationService {

    @Resource(name = "reservationmybatis")
    ReservationDAO dao;

    @Autowired
    ApplicationContext context;

    public ReservationServiceImpl() {
        System.out.println("ReservationService 시작");
    }

    public ReservationServiceImpl(ReservationDAO dao) {
        this.dao = dao;
    }

    @Override
    public int addReservation(Map<String, String> reservation) {
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
	public List<ReservationVO> getReservationByBodyshopNo(int bodyshop_no) {
		return dao.getReservationByBodyshopNo(bodyshop_no);
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
		System.out.println("service reservationid" + member_id);
		return dao.getReservationByID(member_id);
	}
	
	@Override
	public int finishRepair(int reservation_no, String repaired_time, String repaired_person) {
		System.out.println("serviceimpl");
		return dao.finishRepair(reservation_no, repaired_time, repaired_person);
	}
	

}
