package com.team419.awsegress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team419.awsegress.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}