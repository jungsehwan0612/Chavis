package com.chavis.biz.reserve.dao;

import java.util.List;

import com.chavis.biz.reserve.vo.ReserveVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("reservemybatis")
public class ReserveDAO_mybatis implements ReserveDAO {

    @Autowired
    SqlSession sqlSession = null;

    @Override
    public int addReserve(ReserveVO reserve) {
        return sqlSession.insert("reserveMapper.addreserve",reserve);
    }

    @Override
    public ReserveVO getReserve(String reserveID) {
        return sqlSession.selectOne("reserveMapper.getreserve", reserveID);
    }

    @Override
    public List<ReserveVO> getReserveList() {
        return sqlSession.selectList("reserveMapper.listreserve");
    }

    @Override
    public int updateReserve(ReserveVO reserve) {
        return sqlSession.update("reserveMapper.updatereserve", reserve);
    }

    @Override
    public int removeReserve(String reserveID) {
        return sqlSession.delete("reserveMapper.removeclient", reserveID);
    }

}
