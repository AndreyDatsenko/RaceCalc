package com.fau.race;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class RaceController {

    @RequestMapping("/")
    public String index(Model model) {
        Race race = new Race();
        LocalDate date = LocalDate.of(2016, 05, 20);
        race.setDate(date);
        race.setRaceName("cOLL RACE");
        List<Race> raceList = Arrays.asList(race);
        model.addAttribute("raceList", raceList);
        return "index";
    }

    @RequestMapping("/qualification")
    public String qualification(Model model, @RequestParam("date") String date,
                                @RequestParam("raceName") String raceName ){
        model.addAttribute("raceName", raceName);
        model.addAttribute("date", date);

        return "qualification";
    }


}
