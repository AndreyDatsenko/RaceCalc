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
    public void create(@RequestParam Integer driverId, Lap lap) {
        lapService.saveQualificationLap(lap, driverId);

    }
}
