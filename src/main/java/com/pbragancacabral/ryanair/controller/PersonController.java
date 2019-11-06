package com.pbragancacabral.ryanair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {
    @GetMapping(value = "/")
    public String test() {
        return "person/index";
    }
}