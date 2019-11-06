package com.pbragancacabral.ryanair.controller;

import com.pbragancacabral.ryanair.dao.BaseRepository;
import com.pbragancacabral.ryanair.dao.CrewRepository;
import com.pbragancacabral.ryanair.dao.RosterRepository;
import com.pbragancacabral.ryanair.entity.Base;
import com.pbragancacabral.ryanair.entity.Crew;
import com.pbragancacabral.ryanair.entity.Roster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private RosterRepository rosterRepository;

    @GetMapping(value = "/")
    public String index(Model model) {
        Crew crew = new Crew();
        ArrayList<Base> bases = new ArrayList<>(baseRepository.findAllByOrderByIATACodeAsc());
        ArrayList<Roster> rosters = new ArrayList<>(rosterRepository.findAll());
        model.addAttribute("crew", crew);
        model.addAttribute("bases", bases);
        model.addAttribute("rosters", rosters);
        return "index";
    }

    @PostMapping("/")
    @ResponseBody
    public String index2(@ModelAttribute("crew") Crew crew,
                         @RequestParam("baseId") Long baseId,
                         @RequestParam("rosterPattern") Long rosterId) {
        Base base = baseRepository.getOne(baseId);
        Roster roster = rosterRepository.getOne(rosterId);
        crew.setBase(base);
        crew.setRosterPattern(roster);
        crewRepository.save(crew);
        return "Done.";
    }

}