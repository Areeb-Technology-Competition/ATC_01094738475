package com.example.demo.controllers;

import javax.xml.stream.util.EventReaderDelegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Event;
import com.example.demo.repositories.EventRepository;
import com.example.demo.services.EventService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/events")

public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("/admin/add-event")
    public ModelAndView addEvent() {
        ModelAndView mav = new ModelAndView("admin/addEvent");
        mav.addObject("event", new Event());
        return mav;
    }

    @PostMapping("/admin/add-event")
    public ModelAndView saveEvent(@Valid @ModelAttribute Event event, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("admin/addEvent");
        }
        this.eventService.saveEvent(event);
        return new ModelAndView("redirect:/admin/add-event");
    }

}