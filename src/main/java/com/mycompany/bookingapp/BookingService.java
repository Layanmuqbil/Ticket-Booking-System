/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookingapp;

/**
 *
 * @author Layan
 */

import java.util.*;

public class BookingService {
    private static BookingService instance;

    private final Map<Integer, Event> events = new HashMap<>();
    private final List<Booking> bookings = new ArrayList<>();
    private int nextBookingId = 1;

    private BookingService() {}

    public static BookingService getInstance() {
        if (instance == null) instance = new BookingService();
        return instance;
    }

    public void addEvent(Admin admin, Event event) {
        events.put(event.getId(), event);
        System.out.println(admin.getName() + " added: " + event.getTitle());
    }

    public Collection<Event> listEvents() { return events.values(); }

    public Booking book(Customer customer, int eventId, String ticketType, Payable payment)
            throws SeatsFullException {
        Event event = events.get(eventId);
        if (event == null) throw new InvalidDataException("Event not found: " + eventId);

        Ticket ticket = TicketFactory.create(ticketType, event.getBasePrice());
        event.reserveSeat();
        try {
            payment.pay(ticket.getPrice());
        } catch (RuntimeException e) {
            event.releaseSeat(); 
            throw e;
        }
        Booking booking = new Booking(nextBookingId++, customer, event, ticket, payment.methodName());
        bookings.add(booking);
        return booking;
    }

    public List<Booking> bookingsOf(Customer customer) {
        List<Booking> result = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getCustomer().getId() == customer.getId()) result.add(b);
        }
        return result;
    }
}