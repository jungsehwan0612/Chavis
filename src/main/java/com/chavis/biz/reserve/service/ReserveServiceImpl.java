package com.chavis.biz.reserve.service;

import java.util.List;

import javax.annotation.Resource;

import com.chavis.biz.reserve.dao.ReserveDAO;
import com.chavis.biz.reserve.vo.ReserveVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class ReserveServiceImpl implements ReserveService {

    @Resource(name = "reservemybatis")
    ReserveDAO dao;
    
    @Autowired
    ApplicationContext context;


    public ReserveServiceImpl(ReserveDAO dao)   {
        this.dao = dao;
    }

    @Override
    public int addReserve(ReserveVO reserve) {
        return dao.addReserve(reserve);
    }

    @Override
    public ReserveVO getReserve(String reserveID) {
        return dao.getReserve(reserveID);
    }

    @Override
    public List<ReserveVO> getReserveList() {
        return dao.getReserveList();
    }

    @Override
    public int updateReserve(ReserveVO reserve) {
        return dao.updateReserve(reserve);
    }

    @Override
    public int removeReserve(String reserveID) {
        return dao.removeReserve(reserveID);
    }

}
