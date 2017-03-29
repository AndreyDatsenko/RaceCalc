package com.fau.competition.controller;

import com.fau.competition.domain.Competition;
import com.fau.competition.service.CompetitionService;
import com.fau.driver.domain.Driver;
import com.fau.driver.service.DriverService;
import com.fau.lap.service.LapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/competition")
public class CompetitionController {

    final private CompetitionService competitionService;
    final private DriverService driverService;
    final private LapService lapService;

    public CompetitionController(CompetitionService competitionService, DriverService driverService, LapService lapService) {
        this.competitionService = competitionService;
        this.driverService = driverService;
        this.lapService = lapService;
    }

    @GetMapping("/new")
    public String competitionFormation() {
        return "competitionFormation";
    }

    @PostMapping("/create")
    public String createCompetition(Competition competition) {
        competition.setActive(true);
        int competitionId = competitionService.createCompetition(competition);
        return "redirect:/competition/" + competitionId + "/qualification";
    }

    @ResponseBody
    @GetMapping("/{competitionId}/drivers")
    public List<Driver> drivers(@PathVariable int competitionId) {
        return driverService.driverList(competitionId);
    }

    @GetMapping("/{competitionId}/qualification/result")
    public String qualificationResult(Model model, @PathVariable int competitionId) {
        List<Driver> drivers = driverService.getResultDriverList(competitionId);
        for (Driver driver : drivers) {
            driver.setLaps(lapService.getLapsByDriverId(driver.getId()));
        }
        model.addAttribute("drivers", drivers);
        model.addAttribute("competitionId", competitionId);
        return "qualificationResult";
    }

    @GetMapping("/{competitionId}/qualification")
    public String qualification(@PathVariable int competitionId, Model model) {
        model.addAttribute("competitionId", competitionId);
        return "qualification";
    }

    @GetMapping("/{competitionId}/general")
    public String generalCompetition(@PathVariable int competitionId, Model model) {
        model.addAttribute("drivers", driverService.getResultDriverList(competitionId));
        model.addAttribute("competitionId", competitionId);
        return "generalCompetition";
    }

    @GetMapping("/{competitionId}/general/result")
    public String getGeneralResult(@PathVariable int competitionId, Model model){
        model.addAttribute("result", competitionService.calculateResult(competitionId));
        return "generalResult";
    }

    @GetMapping("/search")
    public String searchByCity(@RequestParam("city") String city, Model model){
      model.addAttribute("competitions", competitionService.searchByCity(city));
      return "citySearch";
    }

    @PostMapping("/close")
    public String closeCompetition() {
        competitionService.closeCompetition();
        return "index";
    }
}
