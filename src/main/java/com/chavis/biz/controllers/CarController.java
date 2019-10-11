package com.chavis.biz.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chavis.biz.service.CarService;
import com.chavis.biz.vo.CarVO;

@CrossOrigin("*")
@RestController
public class CarController {
    @Autowired
    CarService service;

    // CREATE
    @RequestMapping(value = "/Car/register.do", method = RequestMethod.POST)
    public CarVO registerCar(@RequestParam("CarVO") CarVO car) {
        service.registerCar(car);
        return service.getCar(car.getCar_no());
    }

    // READ
    @RequestMapping(value = "/Car/view.do")
    public CarVO getCar(@RequestParam("car_no") int car_no) {
        return service.getCar(car_no);
    }
    
    @RequestMapping(value = "/Car/personalview.do", method=RequestMethod.POST)
    public CarVO getPersonalCar(@RequestBody Map<String, String> map) {
    	System.out.println(map);
    	return service.getPersonalCar(map.get("member_id"));
    }

    @RequestMapping(value = "/Car/list.do")
    public List<CarVO> getCarList() {
        return service.getCarList();
    }

    // UPDATE
    @RequestMapping("/Car/resetTireDistance.do")
    public int resetTireDistance(@RequestParam("car_no") int car_no) {
        return service.resetTireDistance(car_no);
    }

    @RequestMapping("/Car/resetWiperDistance.do")
    public int resetWiperDistance(@RequestParam("car_no") int car_no) {
        return service.resetWiperDistance(car_no);
    }

    @RequestMapping("/Car/resetCooler.do")
    public int resetCooler(@RequestParam("car_no") int car_no) {
        return service.resetCooler(car_no);
    }

    @RequestMapping("/Car/resetEngineOil.do")
    public int resetEngineOil(@RequestParam("car_no") int car_no) {
        return service.resetEngineOil(car_no);
    }

    @RequestMapping("/Car/updateTireDistance.do")
    public int updateTireDistance(@RequestParam("distance") String distance,
            @RequestParam("car_no") int car_no) {
        return service.updateTireDistance(distance, car_no);
    }

    @RequestMapping("/Car/updateWiperDistance.do")
    public int updateWiperDistance(@RequestParam("distance") String distance,
            @RequestParam("car_no") int car_no) {
        return service.updateWiperDistance(distance, car_no);
    }

    @RequestMapping("/Car/updateCooler.do")
    public int updateCooler(@RequestParam("cooler") String cooler, @RequestParam("car_no") int car_no) {
        return service.updateCooler(cooler, car_no);
    }

    @RequestMapping("/Car/updateEngineOil.do")
    public int updateEngineOil(@RequestParam("engineOil") String engineOil,
            @RequestParam("car_no") int car_no) {
        return service.updateEngineOil(engineOil, car_no);
    }

    @RequestMapping("/Car/updateDistance.do")
    public int updateDistance(@RequestParam("distance") String distance,
            @RequestParam("car_no") int car_no) {
        return service.updateDistance(distance, car_no);
    }

    // DELETE
    @RequestMapping(value = "/Car/remove.do", method = RequestMethod.POST)
    public int deleteCar(@RequestParam("car_no") int car_no) {
        return service.deleteCar(car_no);
    }

    @ExceptionHandler(Exception.class)
    public String Ex(Exception exception, Model model) {
        // ReserveController 예외발생시 호출됨
        model.addAttribute("exception", exception);
        return "error";
    }
}
