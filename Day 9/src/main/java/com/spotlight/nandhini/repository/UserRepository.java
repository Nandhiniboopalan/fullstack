package com.spotlight.nandhini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotlight.nandhini.model.User;
import java.util.Optional;



public interface UserRepository extends JpaRepository<User, String>{
 
    Optional<User> findByEmail(String email);
    
} 
