package com.fau.lap.controler;

import com.fau.lap.domain.Lap;
import com.fau.lap.service.LapService;
import com.fau.driver.domein.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/lap")
public class LapController {

    private LapService lapService;

    @Autowired
    public LapController(LapService lapService) {
        this.lapService = lapService;
    }

    @PostMapping("/qualification/time")
    @ResponseBody
    public void create(@RequestParam Integer driverId,
                       @RequestParam String time) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss.SS");
        Lap lap = new Lap();
        lap.setNumber(0);
        lap.setTime(LocalTime.parse(time, format));
        lapService.saveQualificationLap(lap, driverId);

    }


    @RequestMapping("/result")
    public Lap result(Driver driver) {
        return lapService.result(driver);
    }


}
