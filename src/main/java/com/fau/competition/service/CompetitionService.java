package com.fau.competition.service;

import com.fau.competition.domain.Competition;
import com.fau.competition.domain.DriverResultItem;
import com.fau.competition.repository.CompetitionRepository;
import com.fau.driver.domain.Driver;
import com.fau.driver.repository.DriverRepository;
import com.fau.lap.service.LapService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final DriverRepository driverRepository;
    private final LapService lapService;

    public CompetitionService(CompetitionRepository competitionRepository, DriverRepository driverRepository, LapService lapService) {
        this.competitionRepository = competitionRepository;
        this.driverRepository = driverRepository;
        this.lapService = lapService;
    }

    public int createCompetition(Competition competition) {
        return competitionRepository.createCompetition(competition);
    }

    public void closeCompetition() {
        competitionRepository.closeCompetition();
    }

    public List<Competition> searchByCity(String city){
        return competitionRepository.searchByCity(city);
    }

    public List<Competition> getActiveCompetition() {
        return competitionRepository.getActiveCompetition();
    }

    public List<DriverResultItem> calculateResult(int competitionId) {
        List<Driver> drivers = driverRepository.driverList(competitionId);
        drivers.forEach(driver -> driver.setLaps(lapService.getLapsByDriverId(driver.getId())));
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
