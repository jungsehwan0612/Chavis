package com.chavis.biz.car.dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.chavis.biz.car.vo.CarVO;


public class CarDAO{

	private static SqlSessionFactory sessionFactory = null;
	private SqlSession sqlSession;
	static {
		try {
			if(sessionFactory == null) {
				Reader reader = Resources.getResourceAsReader("mybatisXml/mybatis_config.xml");
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public CarDAO() {
		sqlSession = sessionFactory.openSession();
	}

	public CarVO getCar(String car_id) {
		System.out.println("CarDAO_getCar");
		return (CarVO)sqlSession.selectOne("car.getCar",car_id);
	}
	public void registerCar(CarVO vo) {
		System.out.println("CarDAO_registerCar");
		System.out.println(sqlSession);
		sqlSession.insert("car.insertCar", vo);
		sqlSession.commit();
	}
	public void tireDistanceReset(String car_id) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("CarDAO_tireDistanceReset");
		map.put("tire_change_distance","0");
		map.put("car_id",car_id);
		sqlSession.update("car.updateTireDistance", map);
		sqlSession.commit();
	}
	public void wiperDistanceReset(String car_id) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("CarDAO_wiperDistanceReset");
		map.put("wiper_change_distance","0");
		map.put("car_id",car_id);
		sqlSession.update("car.updateWiperDistance", map);
		sqlSession.commit();
	}
	public void coolerReset(String car_id) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("CarDAO_coolerReset");
		map.put("cooler_left","100");
		map.put("car_id",car_id);
		sqlSession.update("car.updateCooler", map);
		sqlSession.commit();
	}
	public void engineOilReset(String car_id) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("CarDAO_engineOilReset");
		map.put("engine_oil_left","100");
		map.put("car_id",car_id);
		sqlSession.update("car.updateEngineOil", map);
		sqlSession.commit();
	}
	public void updateTireDistance(String distance,String car_id) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("CarDAO_updateTireDistance");
		map.put("tire_change_distance", distance);
		map.put("car_id",car_id);
		sqlSession.update("car.updateTireDistance", map);
		sqlSession.commit();
	}
	public void updateWiperDistance(String distance,String car_id) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("CarDAO_updateWiperDistance");
		map.put("wiper_change_distance", distance);
		map.put("car_id",car_id);
		sqlSession.update("car.updateWiperDistance", map);
		sqlSession.commit();
	}
	public void updateCooler(String cooler,String car_id) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("CarDAO_updateCooler");
		map.put("cooler_left", cooler);
		map.put("car_id",car_id);
		sqlSession.update("car.updateCooler", map);
		sqlSession.commit();
	}
	public void updateEngineOil(String engineOil,String car_id) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("CarDAO_updateEngineOil");
		map.put("engine_oil_left", engineOil);
		map.put("car_id",car_id);
		sqlSession.update("car.updateEngineOil", map);
		sqlSession.commit();
	}
	public void updateDistance(String distance,String car_id) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("CarDAO_updateDistance");
		map.put("distance", distance);
		map.put("car_id",car_id);
		sqlSession.update("car.updateDistance", map);
		sqlSession.commit();
	}
	public void deleteCar(String car_id) {
		System.out.println("CarDAO_deleteCar");
		sqlSession.delete("car.deleteCar", car_id);
		sqlSession.commit();
	}
	public List<CarVO> getCarList(){
		System.out.println("CarDAO_getCarList");
		return sqlSession.selectList("car.getCarList");
	}
	
}
