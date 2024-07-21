package com.vsmb.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health_Checker {
    @GetMapping("/healthChecker")
    public String healthChecker(){
        return "Ok";
    }
}
