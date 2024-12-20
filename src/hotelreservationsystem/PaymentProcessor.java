package hotelreservationsystem;

// Singleton: PaymentProcessor
// Singleton: Handles payment processing
class PaymentProcessor {
    private static PaymentProcessor instance; // Holds the single instance

    // Private constructor to prevent external instantiation
    private PaymentProcessor() {}

    // Static method to return the single instance
    public static synchronized PaymentProcessor getInstance() {
        if (instance == null) {
            instance = new PaymentProcessor();
        }
        return instance;
    }

    // Processes a payment
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount);
    }
}
