package com.titgroup.myFirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Car {

    @Autowired
    private Dog dog; //This is a field and above line is notation or Depndency injection

    @GetMapping("/ok")
    public String ok(){
        return dog.fun();
    }

}
