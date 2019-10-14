package com.chavis.biz.dao;

import java.util.List;
import java.util.Map;

import com.chavis.biz.vo.ReservationListVO;
import com.chavis.biz.vo.ReservationVO;

public interface ReservationDAO {
	// Create
	int addReservation(Map<String, String> reservation);

	// Read
	ReservationVO getReservation(int reservation_no);

	// List
	List<ReservationVO> getReservationToday();

	// ListByID
	List<ReservationVO> getReservationByID(String member_id);

	// Update
	int updateReservation(ReservationVO reservation);

	// Delete
	int removeReservation(int reserve_no);

	List<ReservationListVO> getReservationList(String id);
	
	int finishRepair(int reservation_no, String repaired_time, String repaired_person);
	}
