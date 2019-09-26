package com.chavis.biz.reserve.dao;

import java.awt.List;

import com.chavis.biz.reserve.vo.reserveVO;

public interface reserveDAO {
	int addReserve(reserveVO reserve);
	
	reserveVO getReserveId(String reserveId);
}
