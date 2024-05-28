package com.anke.Backend_Spring_Anke.controller;

import com.anke.Backend_Spring_Anke.impl.ServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This class is a controller
@RequestMapping("/anke") // Path to the controller
public class Controller {

    private final ServiceImpl service;

    public Controller(ServiceImpl service) {
        this.service = service;
    }
}
