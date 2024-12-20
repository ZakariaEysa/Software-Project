package hotelreservationsystem;

// Abstract class representing a Customer
abstract class Customer {
    public abstract String getCustomerType(); // Type of the customer
}

// Concrete class for Regular Customer
class RegularCustomer extends Customer {
    @Override
    public String getCustomerType() {
        return "Regular Customer";
    }
}

// Concrete class for VIP Customer
class VIPCustomer extends Customer {
    @Override
    public String getCustomerType() {
        return "VIP Customer";
    }
}

// Concrete class for Corporate Customer
class CorporateCustomer extends Customer {
    @Override
    public String getCustomerType() {
        return "Corporate Customer";
    }
}

