package com.fau.driver.controller;

import com.fau.driver.domain.Driver;
import com.fau.driver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("{competitionId}/create")
    public void create(@PathVariable int competitionId, Driver driver) {
        driverService.createDriver(competitionId, driver);
    }

    @PostMapping("/{driverId}/edit")
    public void update(@PathVariable int driverId, Driver driver) {
        driver.setId(driverId);
        driverService.updateDriver(driver);
    }

    @PostMapping("/{driverId}/delete")
    public void delete(@PathVariable Integer driverId) {
        driverService.deleteDriver(driverId);
    }

    @GetMapping("/{driverId}/get")
    public Driver getDriverById(@PathVariable int driverId) {
        return driverService.getDriverById(driverId);
    }
}
