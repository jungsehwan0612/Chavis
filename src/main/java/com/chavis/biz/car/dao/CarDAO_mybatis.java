package com.chavis.biz.car.dao;

import java.util.List;

import com.chavis.biz.car.vo.CarVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carmybatis")
public class CarDAO_mybatis implements CarDAO {

	@Autowired
	SqlSession sqlSession;

	// CREATE
	@Override
	public int registerCar(CarVO car) {
		return sqlSession.insert("carMapper.addCar", car);
	}

	// READ
	@Override
	public CarVO getCar(int car_no) {
		return sqlSession.selectOne("carMapper.getCar", car_no);
	}

	@Override
	public List<CarVO> getCarList() {
		return sqlSession.selectList("carMapper.getCarList");
	}

	// UPDATE
	@Override
	public int resetTireDistance(int car_no) {
		CarVO car = new CarVO();
		car.setCar_no(car_no);
		car.setTire_change_distance("0");
		return sqlSession.update("carMapper.updateTireDistance", car);

	}

	@Override
	public int resetWiperDistance(int car_no) {
		CarVO car = new CarVO();
		car.setCar_no(car_no);
		car.setWiper_change_distance("0");
		return sqlSession.update("carMapper.updateWiperDistance", car);

	}

	@Override
	public int resetCooler(int car_no) {
		CarVO car = new CarVO();
		car.setCar_no(car_no);
		car.setCooler_left("100");
		return sqlSession.update("carMapper.updateCooler", car);
	}



	@Override
	public int resetEngineOil(int car_no) {
		CarVO car = new CarVO();
		car.setCar_no(car_no);
		car.setEngine_oil_viscosity("100");
		return sqlSession.update("carMapper.updateEngineOil", car);

	}

	@Override
	public int updateTireDistance(String distance, int car_no) {
		CarVO car = new CarVO();
		car.setCar_no(car_no);
		car.setTire_change_distance(distance);
		return sqlSession.update("carMapper.updateTireDistance", car);
	}

	@Override
	public int updateWiperDistance(String distance, int car_no) {
		CarVO car = new CarVO();
		car.setCar_no(car_no);
		car.setWiper_change_distance(distance);
		return sqlSession.update("carMapper.updateWiperDistance", car);

	}

	@Override
	public int updateCooler(String cooler, int car_no) {
		CarVO car = new CarVO();
		car.setCar_no(car_no);
		car.setCooler_left(cooler);
		return sqlSession.update("carMapper.updateCooler", car);

	}

	@Override
	public int updateEngineOil(String engineOil, int car_no) {
		CarVO car = new CarVO();
		car.setCar_no(car_no);
		car.setEngine_oil_viscosity(engineOil);
		return sqlSession.update("carMapper.updateEngineOil", car);
	}

	@Override
	public int updateDistance(String distance, int car_no) {
		CarVO car = new CarVO();
		car.setCar_no(car_no);
		car.setDistance(distance);
		return sqlSession.update("carMapper.updateDistance", car);

	}

	@Override
	public int deleteCar(int car_no) {
		return sqlSession.delete("carMapper.removeCar", car_no);
	}
}
