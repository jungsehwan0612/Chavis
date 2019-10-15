package com.chavis.biz.service;

import java.util.List;
import java.util.Map;

import com.chavis.biz.vo.ReservationVO;
import com.chavis.biz.vo.WebTableVO;

public interface ReservationService {
	// Create
	int addReservation(Map<String, String> map);

	// List
	List<ReservationVO> getReservationList();

	// ListByID
	List<ReservationVO> getReservationByID(String member_id);

    
    // ListByBodyshopNo
    List<ReservationVO> getReservationByBodyshopNo(int bodyshop_no);
    // ListForWebTable
    List<WebTableVO> getReservationForWeb(int bodyshop_no);
    // Update
    int updateReservation(ReservationVO reservation);

	// Delete
	int removeReservation(int reserve_no);

	public int finishRepair(int reservation_no, String repaired_time, String repaired_person);
}
