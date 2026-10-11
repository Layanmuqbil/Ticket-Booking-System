/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookingapp;

/**
 *
 * @author Layan
 */

import javax.swing.*;
import java.awt.*;

public class BookingGUI extends JFrame {
    private final BookingService service = BookingService.getInstance();
    private final DefaultListModel<Event> eventModel = new DefaultListModel<>();
    private final JList<Event> eventList = new JList<>(eventModel);
    private final JTextField nameField = new JTextField("Ahmed");
    private final JComboBox<String> ticketBox = new JComboBox<>(new String[]{"Regular", "VIP"});
    private final JComboBox<String> payBox = new JComboBox<>(new String[]{"Cash", "Card"});
    private final JTextField cardField = new JTextField();
    private final JTextArea log = new JTextArea(8, 40);

    public BookingGUI() {
        super("Ticket Booking System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

       
        Admin admin = new Admin(1, "Sara", "sara@mail.com");
        service.addEvent(admin, new Event(1, "Java Conference", 100, 2));
        service.addEvent(admin, new Event(2, "Football Match", 50, 100));
        service.addEvent(admin, new Event(3, "Tech Expo", 80, 50));
        refreshEvents();

        
        eventList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScroll = new JScrollPane(eventList);
        listScroll.setBorder(BorderFactory.createTitledBorder("Events"));

        
        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Booking"));
        form.add(new JLabel("Your name:"));
        form.add(nameField);
        form.add(new JLabel("Ticket type:"));
        form.add(ticketBox);
        form.add(new JLabel("Payment:"));
        form.add(payBox);
        form.add(new JLabel("Card number (16 digits):"));
        form.add(cardField);
        cardField.setEnabled(false);

        payBox.addActionListener(e ->
                cardField.setEnabled("Card".equals(payBox.getSelectedItem())));

        JButton bookBtn = new JButton("Book Ticket");
        bookBtn.addActionListener(e -> onBook());

        JPanel top = new JPanel(new BorderLayout(8, 8));
        top.add(form, BorderLayout.CENTER);
        top.add(bookBtn, BorderLayout.SOUTH);

        
        log.setEditable(false);
        JScrollPane logScroll = new JScrollPane(log);
        logScroll.setBorder(BorderFactory.createTitledBorder("My bookings"));

        JPanel right = new JPanel(new BorderLayout(8, 8));
        right.add(top, BorderLayout.NORTH);
        right.add(logScroll, BorderLayout.CENTER);

        JPanel root = new JPanel(new GridLayout(1, 2, 10, 10));
        root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        root.add(listScroll);
        root.add(right);

        setContentPane(root);
        setSize(850, 450);
        setLocationRelativeTo(null);
    }

    private void refreshEvents() {
        eventModel.clear();
        for (Event ev : service.listEvents()) {
            eventModel.addElement(ev);
        }
    }

    private void onBook() {
        Event selected = eventList.getSelectedValue();
        String name = nameField.getText().trim();

        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Please select an event first.");
            return;
        }
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name.");
            return;
        }

        Customer customer = new Customer(2, name, "");
        String ticketType = (String) ticketBox.getSelectedItem();
        Payable payment = "Card".equals(payBox.getSelectedItem())
                ? new CardPayment(cardField.getText().trim())
                : new CashPayment();

        try {
            Booking booking = service.book(customer, selected.getId(), ticketType, payment);
            log.append(booking + "\n");
            JOptionPane.showMessageDialog(this, "Booking confirmed!");
        } catch (SeatsFullException | InvalidDataException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        refreshEvents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookingGUI().setVisible(true));
    }
}