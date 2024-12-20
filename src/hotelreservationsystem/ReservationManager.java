package hotelreservationsystem;

import java.util.ArrayList;
import java.util.List;

// Singleton: ReservationManager
// Singleton: Manages all room reservations
class ReservationManager {
    private static ReservationManager instance; // Holds the single instance
    private List<String> reservations;         // List of reservations

    // Private constructor to prevent external instantiation
    private ReservationManager() {
        reservations = new ArrayList<>();
    }

    // Static method to return the single instance
    public static synchronized ReservationManager getInstance() {
        if (instance == null) {
            instance = new ReservationManager();
        }
        return instance;
    }

    // Adds a new reservation
    public void addReservation(String reservation) {
        reservations.add(reservation);
        System.out.println("Reservation Added: " + reservation);
    }

    // Retrieves the list of reservations
    public List<String> getReservations() {
        return reservations;
    }
}
