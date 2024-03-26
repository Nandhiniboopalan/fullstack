package com.spotlight.nandhini.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spotlight.nandhini.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    
}
