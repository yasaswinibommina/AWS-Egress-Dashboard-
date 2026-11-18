package com.team419.awsegress.service;

import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.rds.model.DescribeDbInstancesRequest;
import software.amazon.awssdk.services.rds.model.DBInstance;

@Service
public class RDSService {

    private final RdsClient rdsClient;

    public RDSService(RdsClient rdsClient) {
        this.rdsClient = rdsClient;
    }

    public String getRdsStatus() {

        DescribeDbInstancesRequest request =
                DescribeDbInstancesRequest.builder()
                        .dbInstanceIdentifier("team419-rds")
                        .build();

        DBInstance dbInstance =
                rdsClient.describeDBInstances(request)
                        .dbInstances()
                        .get(0);

        return "RDS Status: " + dbInstance.dbInstanceStatus()
                + "\nDatabase: " + dbInstance.dbName()
                + "\nEngine: " + dbInstance.engine()
                + "\nEndpoint: " + dbInstance.endpoint().address()
                + "\nPort: " + dbInstance.endpoint().port();
    }
}