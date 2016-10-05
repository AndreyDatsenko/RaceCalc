package com.alonmack.racer.controller;

import com.alonmack.racer.domein.Racer;
import com.alonmack.racer.service.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/racer")
public class RacerController {

    @Autowired
    private RacerService racerService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("list",racerService.getAll());
        return "list";
    }
}
