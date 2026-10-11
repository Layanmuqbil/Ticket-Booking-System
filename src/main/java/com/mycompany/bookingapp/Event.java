/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookingapp;

/**
 *
 * @author Layan
 */

public class Event {
    private final int id;
    private final String title;
    private final double basePrice;
    private final int capacity;
    private int bookedSeats = 0;

    public Event(int id, String title, double basePrice, int capacity) {
        if (capacity <= 0 || basePrice < 0) throw new InvalidDataException("Invalid event data");
        this.id = id;
        this.title = title;
        this.basePrice = basePrice;
        this.capacity = capacity;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getBasePrice() { return basePrice; }
    public int getAvailableSeats() { return capacity - bookedSeats; }

    public void reserveSeat() throws SeatsFullException {
        if (bookedSeats >= capacity) {
            throw new SeatsFullException("Event '" + title + "' is fully booked");
        }
        bookedSeats++;
    }

    public void releaseSeat() { if (bookedSeats > 0) bookedSeats--; }

    @Override
    public String toString() {
        return String.format("[%d] %s | base price: %.2f | available: %d",
                id, title, basePrice, getAvailableSeats());
    }
}