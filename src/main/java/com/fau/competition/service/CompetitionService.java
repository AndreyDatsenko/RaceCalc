package com.fau.competition.service;

import com.fau.competition.domein.Competition;
import com.fau.competition.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {

    private CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public int createCompetition(Competition competition) {
        return competitionRepository.createCompetition(competition);
    }

    public void closeCompetition() {
        competitionRepository.closeCompetition();
    }

    public List<Competition> getActivCompetition() {
        return competitionRepository.getActivCompetition();
    }
}
