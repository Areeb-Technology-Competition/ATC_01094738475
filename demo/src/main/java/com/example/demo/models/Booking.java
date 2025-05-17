package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import java.util.Objects;


@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "event_id", updatable = false, insertable = false)
    private int eventId;

    @Column(name = "user_id", updatable = false, insertable = false)
    private Long userId; 
    
    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;



    public Booking() {
    }

    public Booking(int id, int eventId, Long userId, User user, Event event) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.user = user;
        this.event = event;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return this.eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Booking id(int id) {
        setId(id);
        return this;
    }

    public Booking eventId(int eventId) {
        setEventId(eventId);
        return this;
    }

    public Booking userId(Long userId) {
        setUserId(userId);
        return this;
    }

    public Booking user(User user) {
        setUser(user);
        return this;
    }

    public Booking event(Event event) {
        setEvent(event);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return id == booking.id && eventId == booking.eventId && Objects.equals(userId, booking.userId) && Objects.equals(user, booking.user) && Objects.equals(event, booking.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventId, userId, user, event);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", eventId='" + getEventId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", user='" + getUser() + "'" +
            ", event='" + getEvent() + "'" +
            "}";
    }
    
}