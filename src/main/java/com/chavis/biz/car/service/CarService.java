package com.chavis.biz.car.service;

import java.util.List;

import com.chavis.biz.car.vo.CarVO;

//@Service
public interface CarService {
	CarVO getCar(String car_id); 								// 1. 등록된 차량 데이터 가져오기
	void registerCar(CarVO vo);   								// 2. 차 등록
	void tireDistanceReset(String car_id); 						// 3. 타이어 주행거리 초기화
	void wiperDistanceReset(String car_id);						// 4. 와이퍼 주행거리 초기화
	void coolerReset(String car_id);								// 5. 냉각수 초기화
	void engineOilReset(String car_id);							// 6. 엔진오일 초기화
	void updateTireDistance(String distance,String car_id);		// 7. 타이어 주행거리 누적
	void updateWiperDistance(String distance,String car_id);		// 8. 와이퍼 주행거리 누적
	void updateCooler(String cooler,String car_id);				// 9. 냉각수 잔량 수정
	void updateEngineOil(String engineOil,String car_id);		// 10. 엔진오일 잔량 수정
	void updateDistance(String distance,String car_id);			// 11. 차량주행거리 누적
	void deleteCar(String car_id);								// 12. 등록된 차량 제거
	List<CarVO> getCarList();									// 13. 등록된 모든 차량 리스트 가져오기
}
