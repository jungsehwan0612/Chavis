package com.chavis.biz.reserve.dao;

import java.util.List;

import com.chavis.biz.reserve.vo.ReserveVO;

public interface ReserveDAO {
	// Create
	int addReserve(ReserveVO reserve);
	// Read
	ReserveVO getReserve(String reserveID);
	List<ReserveVO> getReserveList();
	// Update
	int updateReserve(ReserveVO reserve);
	// Delete
	int removeReserve(String reserveID);
}
