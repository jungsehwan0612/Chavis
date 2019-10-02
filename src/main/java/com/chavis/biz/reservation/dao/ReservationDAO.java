package com.chavis.biz.reservation.dao;

import java.util.List;

import com.chavis.biz.reservation.vo.ReservationVO;

public interface ReservationDAO {
	// Create
	int addReservation(ReservationVO reservation);
	// Read
	ReservationVO getReservation(int reservation_no);
	List<ReservationVO> getReservationToday();
	List<ReservationVO> getReservationWeek();
	// Update
	int updateReservation(ReservationVO reservation);
	// Delete
	int removeReservation(int reserve_no);
}
