package com.fau.lap.service;

import com.fau.lap.domain.Lap;
import com.fau.lap.repository.LapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LapService {

    private final LapRepository lapRepository;

    @Autowired
    public LapService(LapRepository lapRepository) {
        this.lapRepository = lapRepository;
    }

    public void saveQualificationLap(Lap lap, int driverId) {
        lapRepository.saveQualificationLap(lap, driverId);
    }

    public List<Lap> getLaps(){
        return lapRepository.getLaps();
    }
}
