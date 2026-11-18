package com.team419.awsegress.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.S3Object;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;

@Service
public class S3Service {

    private final S3Client s3Client;

    private final String bucketName =
            "team419-egress-2026-yasaswini-7392";

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public List<String> getExportFiles() {

        List<String> files = new ArrayList<>();

        ListObjectsV2Request request = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .prefix("export-data/")
                .build();

        for (S3Object object : s3Client.listObjectsV2(request).contents()) {
            files.add(object.key());
        }

        return files;
    }
}