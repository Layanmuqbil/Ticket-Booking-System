/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookingapp;

/**
 *
 * @author Layan
 */

public class Admin extends User {
    public Admin(int id, String name, String email) { super(id, name, email); }

    @Override
    public String getRole() { return "Admin"; }
}