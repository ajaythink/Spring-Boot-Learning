package com.springboot_react_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
  @GetMapping()
  public String testing() {
    return "Testing completed successfully!";
  }

}
