package com.alonmack.drive.controler;

import com.alonmack.car.domain.Car;
import com.alonmack.drive.domain.Drive;
import com.alonmack.drive.service.DriveService;
import com.alonmack.racer.domein.Racer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drive")
public class DriveControler {
    @Autowired
    private DriveService driveService;

    @RequestMapping("/create")
    public void create(Racer racer, Car car) {
        driveService.create(racer,car);

    }

    @RequestMapping("/addTime")
    public void addTime(Racer racer, Car car, float time, float failTime) {
        driveService.addTime(racer, car, time, failTime);

    }

    @RequestMapping("/result")
    public Drive result(Racer racer, Car car) {
        return driveService.result(racer, car);
    }


}
