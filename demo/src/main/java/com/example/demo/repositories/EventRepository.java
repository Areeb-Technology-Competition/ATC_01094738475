package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Event;

public interface EventRepository extends JpaRepository<Event,Integer>{
    List<Event> findAll();
    Event findById(int id);
    Event deleteById(int id);

}
