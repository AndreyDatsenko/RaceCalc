package com.fau.car.service;

import com.fau.car.domain.Car;
import com.fau.car.repository.CarRepository;
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
