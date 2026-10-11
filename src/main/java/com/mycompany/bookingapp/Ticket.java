/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookingapp;

/**
 *
 * @author Layan
 */
public abstract class Ticket {
    protected final double basePrice;

    public Ticket(double basePrice) { this.basePrice = basePrice; }

    public abstract double getPrice();
    public abstract String getType();
}
