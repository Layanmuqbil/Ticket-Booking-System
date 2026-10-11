/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookingapp;

/**
 *
 * @author Layan
 */


public class TicketFactory {
    public static Ticket create(String type, double basePrice) {
        switch (type.toLowerCase()) {
            case "vip":     return new VipTicket(basePrice);
            case "regular": return new RegularTicket(basePrice);
            default: throw new IllegalArgumentException("Unknown ticket type: " + type);
        }
    }
}