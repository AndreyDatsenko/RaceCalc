package com.fau.lap.repository;

import com.fau.car.domain.Car;
import com.fau.lap.domain.Lap;
import com.fau.driver.domein.Driver;
import org.springframework.stereotype.Repository;

@Repository
public class LapRepository {

    public void addTime(Driver driver, Car car, float time, float failTime){

    }

    public void create(Driver driver, Car car) {

    }

    public Lap result(Driver driver, Car car) {
        return new Lap();
    }
}
