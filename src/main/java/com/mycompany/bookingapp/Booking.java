/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookingapp;

/**
 *
 * @author Layan
 */


public class Booking {
    private final int id;
    private final Customer customer;
    private final Event event;
    private final Ticket ticket;
    private final String paymentMethod;

    public Booking(int id, Customer customer, Event event, Ticket ticket, String paymentMethod) {
        this.id = id;
        this.customer = customer;
        this.event = event;
        this.ticket = ticket;
        this.paymentMethod = paymentMethod;
    }

    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Event getEvent() { return event; }

    @Override
    public String toString() {
        return String.format("Booking #%d | %s | %s | %s | %.2f | %s",
                id, customer.getName(), event.getTitle(),
                ticket.getType(), ticket.getPrice(), paymentMethod);
    }
}