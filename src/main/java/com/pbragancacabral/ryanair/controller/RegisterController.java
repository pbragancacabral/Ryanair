package com.pbragancacabral.ryanair.controller;

import com.pbragancacabral.ryanair.dao.BaseRepository;
import com.pbragancacabral.ryanair.dao.CrewRepository;
import com.pbragancacabral.ryanair.entity.Base;
import com.pbragancacabral.ryanair.entity.Crew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class RegisterController {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private CrewRepository crewRepository;

    @GetMapping(value = "/")
    public String index(Model model) {
        Crew crew = new Crew();
        ArrayList<Base> bases = new ArrayList<>(baseRepository.findAllByOrderByIATACodeAsc());
        model.addAttribute("crew", crew);
        model.addAttribute("bases", bases);
        model.addAttribute("rosters", Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        return "index";
    }

    @PostMapping("/")
    public String index2(@Valid @ModelAttribute("crew") Crew crew, BindingResult bindingResult, Model model
    ) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            ArrayList<Base> bases = new ArrayList<>(baseRepository.findAllByOrderByIATACodeAsc());
            model.addAttribute("rosters", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
            model.addAttribute("bases", bases);
            return "index";
        } else {
            crewRepository.save(crew);
            return "index";
        }
    }

}