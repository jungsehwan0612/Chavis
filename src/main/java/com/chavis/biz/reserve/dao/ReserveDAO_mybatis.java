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
        return sqlSession.insert("reserveMapper.addReserve",reserve);
    }

    @Override
    public ReserveVO getReserve(String reserve_id) {
        return sqlSession.selectOne("reserveMapper.getReserve", reserve_id);
    }

    @Override
    public List<ReserveVO> getReserveList() {
        return sqlSession.selectList("reserveMapper.listReserve");
    }

    @Override
    public int updateReserve(ReserveVO reserve) {
        return sqlSession.update("reserveMapper.updateReserve", reserve);
    }

    @Override
    public int removeReserve(String reserve_id) {
        return sqlSession.delete("reserveMapper.removeReserve", reserve_id);
    }

}
