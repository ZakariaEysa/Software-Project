package hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelReservationSystem {
    public static void main(String[] args) {
        // Observer setup
        BookingNotifier notifier = new BookingNotifier();
        notifier.addObserver(new Staff("Receptionist"));
        notifier.addObserver(new Staff("Manager"));

        // GUI setup
        JFrame frame = new JFrame("Hotel Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Panels setup
        JPanel headerPanel = new JPanel();
        headerPanel.add(new JLabel("Hotel Reservation System"));
        headerPanel.setBackground(new Color(173, 216, 230));

        JPanel roomPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        roomPanel.setBorder(BorderFactory.createTitledBorder("Room Details"));
        JLabel label = new JLabel("Select Room Type:");
        String[] roomTypes = {"Standard", "Deluxe", "Suite"};
        JComboBox<String> roomTypeComboBox = new JComboBox<>(roomTypes);
        roomPanel.add(label);
        roomPanel.add(roomTypeComboBox);

        JPanel customerPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
        JLabel customerLabel = new JLabel("Select Customer Type:");
        String[] customerTypes = {"Regular", "VIP", "Corporate"};
        JComboBox<String> customerTypeComboBox = new JComboBox<>(customerTypes);
        customerPanel.add(customerLabel);
        customerPanel.add(customerTypeComboBox);

        JPanel servicesPanel = new JPanel(new GridLayout(0, 1));
        servicesPanel.setBorder(BorderFactory.createTitledBorder("Additional Services"));
        JCheckBox breakfastCheckBox = new JCheckBox("Breakfast");
        JCheckBox spaCheckBox = new JCheckBox("Spa");
        servicesPanel.add(breakfastCheckBox);
        servicesPanel.add(spaCheckBox);

        JPanel buttonPanel = new JPanel();
        JButton bookButton = new JButton("Book Room");
        buttonPanel.add(bookButton);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Room Factory
                String roomType = (String) roomTypeComboBox.getSelectedItem();
                Room room = RoomFactory.createRoom(roomType);

                // Apply Decorators
                if (breakfastCheckBox.isSelected()) room = new BreakfastDecorator(room);
                if (spaCheckBox.isSelected()) room = new SpaDecorator(room);

                // Customer Factory
                String customerType = (String) customerTypeComboBox.getSelectedItem();
                Customer customer = CustomerFactory.createCustomer(customerType);

                // Add Reservation
                ReservationManager.getInstance().addReservation(
                        customer.getCustomerType() + " booked a " + room.getDescription()
                );
                notifier.notifyObservers(
                        "New booking: " + customer.getCustomerType() + " booked a " + room.getDescription()
                );

                // Payment Processing
                PaymentProcessor.getInstance().processPayment(room.getPrice());
                JOptionPane.showMessageDialog(frame, "Room booked successfully!\n" +
                        "Customer Type: " + customer.getCustomerType() + "\n" +
                        "Room: " + room.getDescription() + "\n" +
                        "Price: $" + room.getPrice());
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(headerPanel);
        mainPanel.add(roomPanel);
        mainPanel.add(customerPanel);
        mainPanel.add(servicesPanel);
        mainPanel.add(buttonPanel);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
