package com.chavis.biz.reserve.dao;

import java.util.List;

import com.chavis.biz.reserve.vo.ReserveVO;

public interface ReserveDAO {
	// Create
	int addReserve(ReserveVO reserve);
	// Read
	ReserveVO getReserve(String reserve_id);
	List<ReserveVO> getReserveToday();
	List<ReserveVO> getReserveWeek();
	// Update
	int updateReserve(ReserveVO reserve_id);
	// Delete
	int removeReserve(String reserve_id);
}
