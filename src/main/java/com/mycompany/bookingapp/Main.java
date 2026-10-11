/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bookingapp;

/**
 *
 * @author Layan
 */

public class Main {
    public static void main(String[] args) {
        BookingService service = BookingService.getInstance();

        Admin admin = new Admin(1, "Layan", "layan@mail.com");
        Customer ahmed = new Customer(2, "Ahmed", "ahmed@mail.com");

        service.addEvent(admin, new Event(1, "Java Conference", 100, 2));
        service.addEvent(admin, new Event(2, "Football Match", 50, 100));

        System.out.println("\n--- Events ---");
        service.listEvents().forEach(System.out::println);

        System.out.println("\n--- Bookings ---");
        try {
            System.out.println(service.book(ahmed, 1, "vip", new CardPayment("1234567812345678")));
            System.out.println(service.book(ahmed, 1, "regular", new CashPayment()));
            System.out.println(service.book(ahmed, 1, "regular", new CashPayment()));
        } catch (SeatsFullException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            service.book(ahmed, 2, "regular", new CardPayment("123")); 
        } catch (InvalidDataException | SeatsFullException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Ahmed's bookings ---");
        service.bookingsOf(ahmed).forEach(System.out::println);
    }
}
