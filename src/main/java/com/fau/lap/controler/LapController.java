package com.fau.lap.controler;

import com.fau.lap.domain.Lap;
import com.fau.lap.service.LapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lap")
public class LapController {

    private final LapService lapService;

    @Autowired
    public LapController(LapService lapService) {
        this.lapService = lapService;
    }

    @PostMapping("/{driverId}/save/time")
    public void create(@PathVariable int driverId, Lap lap) {
        lapService.saveQualificationLap(lap, driverId);
    }
}
