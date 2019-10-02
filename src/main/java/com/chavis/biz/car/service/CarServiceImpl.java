package com.chavis.biz.car.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.chavis.biz.car.dao.CarDAO;
import com.chavis.biz.car.vo.CarVO;

@Service("carservice")
public class CarServiceImpl implements CarService {
	
	@Resource(name = "carmybatis")
	CarDAO dao;

	@Autowired
	ApplicationContext context;

	public CarServiceImpl(CarDAO dao) {
		this.dao = dao;
	}
	// CREATE
	@Override
	public int registerCar(CarVO car) {
		return dao.registerCar(car);
	}

	// READ
	@Override
	public CarVO getCar(int car_no) {
		return dao.getCar(car_no);
	}

	@Override
	public List<CarVO> getCarList() {
		return dao.getCarList();
	}

	// UPDATE
	@Override
	public int resetTireDistance(int car_no) {
		return dao.resetTireDistance(car_no);
	}

	@Override
	public int resetWiperDistance(int car_no) {
		return dao.resetWiperDistance(car_no);
	}

	@Override
	public int resetCooler(int car_no) {
		return dao.resetCooler(car_no);
	}

	@Override
	public int resetEngineOil(int car_no) {
		return dao.resetEngineOil(car_no);
	}

	@Override
	public int updateTireDistance(String distance, int car_no) {
		return dao.updateTireDistance(distance, car_no);
	}

	@Override
	public int updateWiperDistance(String distance, int car_no) {
		return dao.updateWiperDistance(distance, car_no);
	}

	@Override
	public int updateCooler(String cooler_left, int car_no) {
		return dao.updateCooler(cooler_left, car_no);
	}

	@Override
	public int updateEngineOil(String engineOil, int car_no) {
		return dao.updateEngineOil(engineOil, car_no);
	}

	@Override
	public int updateDistance(String distance, int car_no) {
		return dao.updateDistance(distance, car_no);
	}
	// DELETE

	@Override
	public int deleteCar(int car_no) {
		return dao.deleteCar(car_no);
	}

	@Override
	public int getCarNo(String car_id) {
		return dao.getCarNo(car_id);
	}

}
