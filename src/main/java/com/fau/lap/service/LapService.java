package com.fau.lap.service;

import com.fau.car.domain.Car;
import com.fau.lap.domain.Lap;
import com.fau.lap.repository.LapRepository;
import com.fau.driver.domein.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LapService {

    @Autowired
    private LapRepository lapRepository;

    public void addTime(Driver driver, Car car, float time, float failTime){
        lapRepository.addTime(driver, car, time, failTime);

    }

    public void create(Driver driver, Car car) {

        lapRepository.create(driver, car);
    }

    public Lap result(Driver driver, Car car) {
        return lapRepository.result(driver, car);

    }
}
