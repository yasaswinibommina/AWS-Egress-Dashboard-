package com.team419.awsegress.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/api/status")
    public String status() {
        return "AWS Egress Dashboard Backend is running successfully!";
    }
}