package com.fau.lap.controler;

import com.fau.car.domain.Car;
import com.fau.lap.domain.Lap;
import com.fau.lap.service.LapService;
import com.fau.driver.domein.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drive")
public class LapController {
    @Autowired
    private LapService lapService;

    @RequestMapping("/create")
    public void create(Driver driver, Car car) {
        lapService.create(driver,car);

    }

    @RequestMapping("/addTime" )
    public void addTime(Driver driver, Car car, float time, float failTime) {
        lapService.addTime(driver, car, time, failTime);

    }

    @RequestMapping("/result")
    public Lap result(Driver driver, Car car) {
        return lapService.result(driver, car);
    }


}
