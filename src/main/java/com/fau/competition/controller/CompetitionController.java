package com.fau.competition.controller;

import com.fau.competition.domein.Competition;
import com.fau.competition.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/competition")
public class CompetitionController {

    private CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @PostMapping("/create")
    public String createCompetition(@RequestParam String date,
                                    @RequestParam String competitionName,
                                    @RequestParam String competitionCity,
                                    @RequestParam String chipBoard,
                                    @RequestParam String chipFront,
                                    @RequestParam String falseStart) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss.SS");
        Competition competition = new Competition();
        competition.setDate(LocalDate.parse(date));
        competition.setCompetitionName(competitionName);
        competition.setCompetitionCity(competitionCity);
        competition.setActive(true);
        competition.setChipBoard(LocalTime.parse(chipBoard, format));
        competition.setChipFront(LocalTime.parse(chipFront, format));
        competition.setFalseStart(LocalTime.parse(falseStart, format));
        competitionService.saveCompetition(competition);
        return "redirect:/competition/qualification";
    }

    @GetMapping("/all")
    public String allCompetition(Model model) {
        return "competitionList";
    }

    @GetMapping("/qualification")
    public String qualification(Model model) {

        return "qualification";
    }


}
