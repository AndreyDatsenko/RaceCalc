package com.fau.competition.service;

import com.fau.competition.domain.Competition;
import com.fau.competition.domain.DriverResultItem;
import com.fau.competition.repository.CompetitionRepository;
import com.fau.driver.domain.Driver;
import com.fau.driver.repository.DriverRepository;
import com.fau.lap.domain.Lap;
import com.fau.lap.service.LapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final DriverRepository driverService;
    private final LapService lapService;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository, DriverRepository driverService, LapService lapService) {
        this.competitionRepository = competitionRepository;
        this.driverService = driverService;
        this.lapService = lapService;
    }

    public int createCompetition(Competition competition) {
        return competitionRepository.createCompetition(competition);
    }

    public List<Driver> getQualificationResult(int competitionId) {
        List<Lap> laps = lapService.getLaps();
        return driverService.getOrderedDriversByQualificationResult(competitionId).stream()
                .map(driver -> {
                    driver.setLaps(laps.stream()
                            .filter(lap -> lap.getDriver_id() == driver.getId())
                            .collect(Collectors.toList()));
                    return driver;
                })
                .collect(Collectors.toList());
    }

    public void closeCompetition() {
        competitionRepository.closeCompetition();
    }

    public List<Competition> searchByCity(String city) {
        return competitionRepository.searchByCity(city);
    }

    public List<Competition> getActiveCompetitions() {
        return competitionRepository.getActiveCompetitions();
    }

    public List<DriverResultItem> calculateResult(int competitionId) {
        List<Driver> drivers = getQualificationResult(competitionId);
        return drivers.stream()
                .map(driver -> {
                    DriverResultItem item = new DriverResultItem();
                    item.setDriverName(driver.getName() + " " + driver.getSurname());
                    item.setFirstLap(driver.getLaps().get(0).getTime().toNanoOfDay());
                    item.setSecondLap(driver.getLaps().get(1).getTime().toNanoOfDay());
                    item.setThirdLap(driver.getLaps().get(2).getTime().toNanoOfDay());
                    return item;
                }).collect(Collectors.toList());
    }
}
