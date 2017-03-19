package com.fau.lap.controler;

import com.fau.lap.domain.Lap;
import com.fau.lap.service.LapService;
import com.fau.driver.domein.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lap")
public class LapController {
    @Autowired
    private LapService lapService;

    @RequestMapping("/create")
    public void create(Driver driver) {
        lapService.create(driver);

    }

    @RequestMapping("/addTime" )
    public void addTime(Driver driver, float time, float failTime) {
        lapService.addTime(driver, time, failTime);

    }

    @RequestMapping("/result")
    public Lap result(Driver driver) {
        return lapService.result(driver);
    }


}
