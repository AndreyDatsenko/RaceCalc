package com.fau.driver.controller;

import com.fau.car.domain.Car;
import com.fau.driver.domein.Driver;
import com.fau.driver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Driver> list(Model model) {
        return driverService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public void save (@RequestParam("name") String name,
                      @RequestParam("surname") String surname,
                      @RequestParam("number") Integer number,
                      @RequestParam("category") String category,
                      @RequestParam("mark") String mark) {

        driverService.save(new Driver(name, surname, number, new Car(category, mark)));
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public void update(@PathVariable("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("surname") String surname,
                       @RequestParam("number") Integer number,
                       @RequestParam("category") String category,
                       @RequestParam("mark") String mark) {

        driverService.update(new Driver(id, name, surname, number, new Car(category, mark)));
    }

@RequestMapping("/{id}/delete")
@ResponseBody
    public void delete(@PathVariable("id") Integer id) {

        driverService.delete(id);
}

//    @RequestMapping(value = "/save/result", method = RequestMethod.POST)
//    @ResponseBody
//    public void saveWithResultTime(@RequestParam("name") String name,
//                                   @RequestParam("surname") String surname,
//                                   @RequestParam("number") Integer number,
//                                   @RequestParam("category") String category,
//                                   @RequestParam("mark") String mark,
//                                   @RequestParam("time") String time){
//        Car car = new Car();
//        car.setCategory(category);
//        car.setMark(mark);
//        Driver driver = new Driver();
//        driver.setName(name);
//        driver.setSurname(surname);
//        driver.setNumber(number);
//        driver.setCar(car);
//        LocalTime localTime = LocalTime.parse(time);
//        driverService.saveDriversWithResult(driver, localTime);
//    }

    @RequestMapping("/result/list")
    public String qualificationResult(Model model,
                                      @RequestParam("date") String date,
                                      @RequestParam("raceName") String raceName){
        model.addAttribute("date", date);
        model.addAttribute("raceName", raceName);
        model.addAttribute("listResult", driverService.getOrderDrivers());
        return "qualificationResult";
    }
}
