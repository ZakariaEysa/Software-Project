package hotelreservationsystem;

public class CustomerFactory {
    public static Customer createCustomer(String type) {
        switch (type.toLowerCase()) {
            case "regular":
                return new RegularCustomer();
            case "vip":
                return new VIPCustomer();
            case "corporate":
                return new CorporateCustomer();
            default:
                throw new IllegalArgumentException("Invalid customer type");
        }
    }
}
