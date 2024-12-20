package hotelreservationsystem;

// Observer Interface

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message); // Method to be implemented by observers
}

// Concrete Observer: Staff
class Staff implements Observer {
    private String name;

    public Staff(String name) {
        this.name = name; // Staff name
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to " + name + ": " + message); // Display notification
    }
}

// Subject: BookingNotifier
class BookingNotifier {
    private List<Observer> observers = new ArrayList<>(); // List of observers

    // Add an observer to the list
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Notify all observers about an event
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
