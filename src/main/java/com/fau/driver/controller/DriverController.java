package com.fau.driver.controller;

import com.fau.driver.domein.Driver;
import com.fau.driver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Driver> list() {
        return driverService.driverList();
    }

    @PostMapping("/save")
    @ResponseBody
    public void save(@RequestParam String name,
                     @RequestParam String surname,
                     @RequestParam Integer number,
                     @RequestParam String category,
                     @RequestParam String mark) {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setSurname(surname);
        driver.setNumber(number);
        driver.setCarCategory(category);
        driver.setCarMark(mark);
        driverService.saveDriver(driver);
    }

    @PostMapping("/{id}/edit")
    @ResponseBody
    public void update(@PathVariable Integer id,
                       @RequestParam String name,
                       @RequestParam String surname,
                       @RequestParam Integer number,
                       @RequestParam String category,
                       @RequestParam String mark) {
        Driver driver = new Driver();
        driver.setId(id);
        driver.setName(name);
        driver.setSurname(surname);
        driver.setNumber(number);
        driver.setCarCategory(category);
        driver.setCarMark(mark);
        driverService.updateDriver(driver);

    }

    @PostMapping("/{id}/delete")
    @ResponseBody
    public void delete(@PathVariable Integer id) {

        driverService.deleteDriver(id);
    }

    @GetMapping("/qualification/result")
    public String qualificationResult(Model model) {
        model.addAttribute("drivers", driverService.getResultQualificationList());
        return "qualificationResult";
    }
}
