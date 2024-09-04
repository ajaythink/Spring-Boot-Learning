package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helper {
  @GetMapping("/testing")
  public String testing() {
    return "We are testing the helper class";
  }
}
