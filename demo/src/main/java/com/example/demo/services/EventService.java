package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Event;
import com.example.demo.repositories.EventRepository;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;
    public Event saveEvent(Event event) {
        try {
            return eventRepository.save(event);
        } catch (Exception e) {
            throw e;
        }
    }

}
