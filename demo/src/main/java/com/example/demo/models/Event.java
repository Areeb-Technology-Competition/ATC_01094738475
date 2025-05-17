package com.example.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String category;
    private String venue;
    private float price;
    private String image;
    private LocalDate date;

    public Event() {
    }

    public Event(int id, String name, String description, String category, String venue, float price, String image, LocalDate date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.venue = venue;
        this.price = price;
        this.image = image;
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVenue() {
        return this.venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Event id(int id) {
        setId(id);
        return this;
    }

    public Event name(String name) {
        setName(name);
        return this;
    }

    public Event description(String description) {
        setDescription(description);
        return this;
    }

    public Event category(String category) {
        setCategory(category);
        return this;
    }

    public Event venue(String venue) {
        setVenue(venue);
        return this;
    }

    public Event price(float price) {
        setPrice(price);
        return this;
    }

    public Event image(String image) {
        setImage(image);
        return this;
    }

    public Event date(LocalDate date) {
        setDate(date);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Event)) {
            return false;
        }
        Event event = (Event) o;
        return id == event.id && Objects.equals(name, event.name) && Objects.equals(description, event.description) && Objects.equals(category, event.category) && Objects.equals(venue, event.venue) && price == event.price && Objects.equals(image, event.image) && Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, category, venue, price, image, date);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", category='" + getCategory() + "'" +
            ", venue='" + getVenue() + "'" +
            ", price='" + getPrice() + "'" +
            ", image='" + getImage() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }

}
