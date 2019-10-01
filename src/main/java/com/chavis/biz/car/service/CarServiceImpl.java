package com.chavis.biz.car.service;

import java.util.List;

import com.chavis.biz.car.dao.CarDAO;
import com.chavis.biz.car.vo.CarVO;

public class CarServiceImpl implements CarService{
	
	CarDAO dao = new CarDAO();
	
	
	public CarServiceImpl() {
		super();
	}
	public CarServiceImpl(CarDAO dao) {
		this.dao = dao;
	}
	public CarDAO getDao() {
		return dao;
	}
	public void setDao(CarDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public CarVO getCar(String car_id) {
		return dao.getCar(car_id);
	}

	@Override
	public void registerCar(CarVO vo) {
		dao.registerCar(vo);
	}

	@Override
	public void tireDistanceReset(String car_id) {
		dao.tireDistanceReset(car_id);
	}

	@Override
	public void wiperDistanceReset(String car_id) {
		dao.wiperDistanceReset(car_id);
	}

	@Override
	public void coolerReset(String car_id) {
		dao.coolerReset(car_id);
	}

	@Override
	public void engineOilReset(String car_id) {
		dao.engineOilReset(car_id);
	}

	@Override
	public void deleteCar(String car_id) {
		dao.deleteCar(car_id);
	}
	@Override
	public void updateTireDistance(String distance, String car_id) {
		dao.updateTireDistance(distance, car_id);
	}

	@Override
	public void updateWiperDistance(String distance, String car_id) {
		dao.updateWiperDistance(distance, car_id);
	}

	@Override
	public void updateCooler(String cooler, String car_id) {
		dao.updateCooler(cooler, car_id);
	}

	@Override
	public void updateEngineOil(String engineOil, String car_id) {
		dao.updateEngineOil(engineOil, car_id);
	}

	@Override
	public void updateDistance(String distance, String car_id) {
		dao.updateDistance(distance, car_id);
	}
	
	@Override
	public List<CarVO> getCarList() {
		return dao.getCarList();
	}

}
