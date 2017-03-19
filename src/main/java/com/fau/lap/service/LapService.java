package com.fau.lap.service;

import com.fau.lap.domain.Lap;
import com.fau.lap.repository.LapRepository;
import com.fau.driver.domein.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LapService {

    @Autowired
    private LapRepository lapRepository;

    public void addTime(Driver driver, float time, float failTime){
        lapRepository.addTime(driver, time, failTime);

    }

    public void create(Driver driver) {

        lapRepository.create(driver);
    }

    public Lap result(Driver driver) {
        return lapRepository.result(driver);

    }
}
