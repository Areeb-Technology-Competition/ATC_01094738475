package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.models.Booking;
import com.example.demo.models.Event;
import com.example.demo.models.User;
import com.example.demo.services.BookingService;
import com.example.demo.services.EventService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    EventService eventService;

    String message = null;

    @GetMapping("/user/booked")
    public void book(@RequestParam int id, HttpServletResponse response, HttpSession session) throws IOException {
        Event event = eventService.findEventById(id);

        Booking booking = new Booking();
        Long userId = (Long) session.getAttribute("user_id");

        if (userId != null) {
            User user = new User();
            user.setId(userId);
            booking.setUser(user);
            booking.setEvent(event);
            this.bookingService.saveBooking(booking);
            this.message = "Booked";
            response.sendRedirect("/booking/congratulations");
        } else {
            response.sendRedirect("/login");
        }

    }

    @GetMapping("/congratulations") 
    public ModelAndView accessDenied() {
        return new ModelAndView("/user/congratulations.html");
    }
 

}
