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

//     @GetMapping("my-bookings")
//     public ModelAndView viewBookings(HttpSession session, HttpServletResponse response) throws IOException {
//         ModelAndView mav = new ModelAndView("/user/bookingList.html");
//         Long userId = (Long) session.getAttribute("user_id");
//         if (userId != null) {
//             Boolean exists = bookingRepository.existsByUserId(userId);
//             if (exists) {
//                 Booking booking = this.bookingRepository.findByUserId(userId);
//                 mav.addObject("booking", booking);
//             } else {
//                 mav.addObject("booking", null);
//                 this.message = "You don't have any booked appointments";
//             }
//         } else {
//             response.sendRedirect("/user/Login");
//         }

//         mav.addObject("message", this.message);
//         this.message = null;

//         return mav;
//     }

//     @GetMapping("/admin/all-bookings")
//     public ModelAndView viewAllBookings() throws IOException {
//         ModelAndView mav = new ModelAndView("/admin/viewBookings.html");
//         List<Booking> bookings = this.bookingRepository.findAll();
//         mav.addObject("bookings", bookings);
//         return mav;
//     }

//     @GetMapping("cancelled")
//     public void cancelBooking(@RequestParam int id, HttpServletResponse response, HttpSession session)
//             throws IOException {
//         Booking booking = bookingRepository.findById(id).get();
//         Appointment appointment = new Appointment();
//         appointment.setDate(booking.getDate());
//         appointment.setStartHr(booking.getStartHr());
//         appointment.setEndHr(booking.getEndHr());
//         appointment.setDoctor(booking.getDoctor());
//         this.appointmentRepository.save(appointment);
//         this.bookingRepository.delete(booking);
//         this.message = "You have cancelled your booking";
//         response.sendRedirect("/user/booking/my-bookings");
//     }

}
