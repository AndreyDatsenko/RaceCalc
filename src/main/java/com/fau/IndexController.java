package com.fau;

import com.fau.competition.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private CompetitionService competitionService;

    @Autowired
    public IndexController(CompetitionService competitionService){
        this.competitionService = competitionService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("competitions", competitionService.getActivCompetition());
        return "index";
    }
}
