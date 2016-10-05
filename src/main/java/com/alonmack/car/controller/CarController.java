package com.alonmack.car.controller;

import com.alonmack.car.domain.Car;
import com.alonmack.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/save")
    public String save(){
        carService.save(new Car());
        return "add";
    }

}
