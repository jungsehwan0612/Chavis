package com.chavis.biz.reserve.dao;

import com.chavis.biz.reserve.vo.ReserveVO;

public interface ReserveDAO {
	int addReserve(ReserveVO reserve);
	
	ReserveVO getReserveId(String reserveId);
}
