package com.fau.lap.repository;

import com.fau.lap.domain.Lap;
import com.fau.driver.domein.Driver;
import org.springframework.stereotype.Repository;

@Repository
public class LapRepository {

    public void addTime(Driver driver, float time, float failTime){

    }

    public void create(Driver driver) {

    }

    public Lap result(Driver driver) {
        return new Lap();
    }
}
