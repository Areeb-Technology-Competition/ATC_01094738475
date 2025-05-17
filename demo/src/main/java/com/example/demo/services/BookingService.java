package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Booking;
import com.example.demo.repositories.BookingRepository;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    
    public void saveBooking(Booking booking){
        bookingRepository.save(booking);
    }
}
