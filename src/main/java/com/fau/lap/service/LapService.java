package com.fau.lap.service;

import com.fau.lap.domain.Lap;
import com.fau.lap.repository.LapRepository;
import com.fau.driver.domein.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LapService {

    private LapRepository lapRepository;

    @Autowired
    public LapService(LapRepository lapRepository) {
        this.lapRepository = lapRepository;
    }

    public void saveQualificationLap(Lap lap, int driverId) {
        lapRepository.saveQualificationLap(lap, driverId);
    }

}
