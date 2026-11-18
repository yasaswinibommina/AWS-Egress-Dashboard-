package com.team419.awsegress.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team419.awsegress.service.ExportService;

@RestController
public class ExportController {

    private final ExportService exportService;

    public ExportController(ExportService exportService) {
        this.exportService = exportService;
    }

    @GetMapping("/api/exports")
    public String getExportStatus() {
        return exportService.getExportStatus();
    }
}