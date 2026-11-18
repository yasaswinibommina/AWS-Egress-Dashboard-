package com.team419.awsegress.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team419.awsegress.service.RDSService;

@RestController
public class RDSController {

    private final RDSService rdsService;

    public RDSController(RDSService rdsService) {
        this.rdsService = rdsService;
    }

    @GetMapping("/api/rds/status")
    public String getRdsStatus() {
        return rdsService.getRdsStatus();
    }
}