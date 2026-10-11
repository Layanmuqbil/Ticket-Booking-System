/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookingapp;

/**
 *
 * @author Layan
 */
public class VipTicket extends Ticket {
    private static final double VIP_MULTIPLIER = 2.5;

    public VipTicket(double basePrice) { super(basePrice); }

    @Override public double getPrice() { return basePrice * VIP_MULTIPLIER; }
    @Override public String getType() { return "VIP"; }
}