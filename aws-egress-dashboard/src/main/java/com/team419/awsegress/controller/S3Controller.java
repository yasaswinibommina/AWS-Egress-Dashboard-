package com.team419.awsegress.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team419.awsegress.service.S3Service;

@RestController
public class S3Controller {

    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @GetMapping("/api/s3/files")
    public List<String> getFiles() {
        return s3Service.getExportFiles();
    }
}