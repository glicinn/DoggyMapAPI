package com.example.doggymapapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
class HomeController {

    @GetMapping({"/", "/home", "/status"})
    public String getStatus(){
        return "Application is up and running";
    }
}
