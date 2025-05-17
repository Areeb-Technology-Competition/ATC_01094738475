package com.example.demo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Booking;


public interface BookingRepository extends JpaRepository<Booking, Integer> {
    
}
