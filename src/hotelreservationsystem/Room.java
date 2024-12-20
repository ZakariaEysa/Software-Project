package hotelreservationsystem;

// Factory: Room Factory
// Abstract class representing a Room
abstract class Room {
    public abstract String getDescription(); // Description of the room
    public abstract double getPrice();       // Price of the room
}

// Concrete class for Standard Room
class StandardRoom extends Room {
    @Override
    public String getDescription() {
        return "Standard Room";
    }

    @Override
    public double getPrice() {
        return 100.0;
    }
}

// Concrete class for Deluxe Room
class DeluxeRoom extends Room {
    @Override
    public String getDescription() {
        return "Deluxe Room";
    }

    @Override
    public double getPrice() {
        return 200.0;
    }
}

// Concrete class for Suite Room
class SuiteRoom extends Room {
    @Override
    public String getDescription() {
        return "Suite Room";
    }

    @Override
    public double getPrice() {
        return 300.0;
    }
}

