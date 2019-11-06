package com.pbragancacabral.ryanair.controller;

import com.pbragancacabral.ryanair.dao.BaseRepository;
import com.pbragancacabral.ryanair.entity.Base;
import com.pbragancacabral.ryanair.entity.Crew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    private BaseRepository baseRepository;

    @GetMapping(value = "/")
    public String index(Model model) {
        Crew crew = new Crew();
        ArrayList<Base> bases = new ArrayList<>(baseRepository.findAllByOrderByIATACodeAsc());
        model.addAttribute("crew", crew);
        model.addAttribute("bases", bases);
        return "index";
    }

    @PostMapping("/")
    @ResponseBody
    public String index2() {
        return "Hi";
    }
}