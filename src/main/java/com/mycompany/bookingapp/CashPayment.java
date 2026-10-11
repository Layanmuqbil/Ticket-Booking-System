/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookingapp;

/**
 *
 * @author Layan
 */
public class CashPayment implements Payable {
    @Override
    public boolean pay(double amount) {
        System.out.printf("Paid %.2f in cash%n", amount);
        return true;
    }

    @Override public String methodName() { return "Cash"; }
}