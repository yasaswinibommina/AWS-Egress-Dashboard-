package com.team419.awsegress.service;

import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.rds.model.DescribeExportTasksRequest;
import software.amazon.awssdk.services.rds.model.ExportTask;

@Service
public class ExportService {

    private final RdsClient rdsClient;

    public ExportService(RdsClient rdsClient) {
        this.rdsClient = rdsClient;
    }

    public String getExportStatus() {

        DescribeExportTasksRequest request =
                DescribeExportTasksRequest.builder()
                        .exportTaskIdentifier("team419-egress-export-2026")
                        .build();

        ExportTask exportTask =
                rdsClient.describeExportTasks(request)
                        .exportTasks()
                        .get(0);

        return "Export ID: " + exportTask.exportTaskIdentifier()
                + "\nStatus: " + exportTask.status()
                + "\nS3 Bucket: " + exportTask.s3Bucket()
                + "\nS3 Prefix: " + exportTask.s3Prefix()
                + "\nKMS Key: " + exportTask.kmsKeyId();
    }
}