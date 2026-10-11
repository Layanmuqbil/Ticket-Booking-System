/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookingapp;

/**
 *
 * @author Layan
 */
public class CardPayment implements Payable {
    private final String cardNumber;

    public CardPayment(String cardNumber) { this.cardNumber = cardNumber; }

    @Override
    public boolean pay(double amount) {
        if (cardNumber == null || cardNumber.length() != 16) {
            throw new InvalidDataException("Card number must be 16 digits");
        }
        System.out.printf("Paid %.2f by card ****%s%n", amount, cardNumber.substring(12));
        return true;
    }

    @Override public String methodName() { return "Card"; }
}