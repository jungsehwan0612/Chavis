package com.chavis.biz.reserve.service;

import java.util.List;

import com.chavis.biz.reserve.vo.ReserveVO;

public interface ReserveService {
    // Create
    int addReserve(ReserveVO reserve);
    // Read
    ReserveVO getReserve(String reserve_id);
    List<ReserveVO> getReserveList();
    // Update
    int updateReserve(ReserveVO reserve);
    // Delete
    int removeReserve(String reseve_id);
}
