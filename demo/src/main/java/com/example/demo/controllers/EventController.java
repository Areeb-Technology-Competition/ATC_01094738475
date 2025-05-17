package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Event;
import com.example.demo.services.EventService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")

public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("/admin")
    public ModelAndView viewEvents(HttpSession httpSession) {
        ModelAndView mav = new ModelAndView("admin/viewEvents.html");
        List<Event> events = this.eventService.findAllEvents();
        mav.addObject("events", events);
        return mav;
    }

    @GetMapping("/admin/add-event")
    public ModelAndView addEvent(HttpSession httpSession) {
        ModelAndView mav = new ModelAndView("admin/addEvent.html");
        Event newEvent = new Event();
        mav.addObject("event", newEvent);
        return mav;
    }


    @PostMapping("/admin/add-event")
    public ModelAndView saveEvent(@Valid @ModelAttribute Event event, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("admin/addEvent.html");
        }
        this.eventService.saveEvent(event);
        return new ModelAndView("redirect:/events/admin/add-event");
    }


    @GetMapping("/admin/edit-event/{id}")
    public ModelAndView editEvent(@PathVariable("id") int id) {
        Event event = eventService.findEventById(id);
        ModelAndView mav = new ModelAndView("/admin/editEvent.html");
        mav.addObject("event", event);
        return mav;
    }

    @PostMapping("/admin/edit-event/{id}")
    public ModelAndView editEvent(@PathVariable("id") int id, @ModelAttribute Event updatedEvent) {
        Event existingEvent = eventService.findEventById(id);
        System.out.println(existingEvent);
        existingEvent.setName(updatedEvent.getName());
        existingEvent.setDescription(updatedEvent.getDescription());
        existingEvent.setImage(updatedEvent.getImage());
        existingEvent.setCategory(updatedEvent.getCategory());
        existingEvent.setDate(updatedEvent.getDate());
        existingEvent.setPrice(updatedEvent.getPrice());
        existingEvent.setVenue(updatedEvent.getVenue());

        eventService.saveEvent(existingEvent); 
        return new ModelAndView("redirect:/events/admin"); 
    }

    @GetMapping("/admin/delete-event/{id}")
    public ModelAndView deleteEvent(@PathVariable("id") int id) {
        this.eventService.deleteEventById(id);
        return new ModelAndView("redirect:/events/admin"); 
    }



}