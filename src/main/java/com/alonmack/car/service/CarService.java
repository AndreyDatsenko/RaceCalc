package com.alonmack.car.service;

import com.alonmack.car.domain.Car;
import com.alonmack.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void save(Car car) {
        carRepository.save(car);
    }
}
