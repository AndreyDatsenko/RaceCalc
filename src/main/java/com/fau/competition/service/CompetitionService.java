package com.fau.competition.service;

import com.fau.competition.domein.Competition;
import com.fau.competition.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionService {

    private CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository){
        this.competitionRepository = competitionRepository;
    }

    public void saveCompetition(Competition competition) {
        competitionRepository.saveCompetition(competition);
    }
}
