package com.spotlight.nandhini.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spotlight.nandhini.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, String> {
    
}
