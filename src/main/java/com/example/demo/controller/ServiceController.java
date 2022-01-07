package com.example.demo.controller;

import com.example.demo.event.ServiceInformation;
import com.example.demo.service.CircuitBreakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @GetMapping
    public List<ServiceInformation> listServiceInformation() {
        return circuitBreakerService.showServiceInformation();
    }
}
