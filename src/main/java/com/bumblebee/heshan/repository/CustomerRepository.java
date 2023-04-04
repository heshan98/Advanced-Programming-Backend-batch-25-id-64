package com.bumblebee.heshan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bumblebee.heshan.model.Customers;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Long> {
    Boolean existsByEmail(String email);
}
