package com.chavis.biz.reservation.service;

import java.util.List;

import com.chavis.biz.reservation.vo.ReservationVO;

public interface ReservationService {
    // Create
    int addReservation(ReservationVO reserveation);
    // Read
    ReservationVO getReservation(int reservation_no);
    List<ReservationVO> getReservationToday();
    List<ReservationVO> getReservationWeek();
    // Update
    int updateReservation(ReservationVO reservation);
    // Delete
    int removeReservation(int reserve_no);
}
