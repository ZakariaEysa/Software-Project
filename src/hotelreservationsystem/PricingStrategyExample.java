
package hotelreservationsystem;

// Strategy Pattern: Pricing strategies
interface PricingStrategy {
    double calculatePrice(double basePrice);
}

class RegularPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }
}

class SeasonalPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 1.2; // زيادة 20% للتسعير الموسمي
    }
}

// Example class for testing PricingStrategy
public class PricingStrategyExample {
    public static void main(String[] args) {
        // Room price (base)
        double basePrice = 150.0;

        // Select strategy dynamically
        PricingStrategy regularStrategy = new RegularPricingStrategy();
        PricingStrategy seasonalStrategy = new SeasonalPricingStrategy();

        // Calculate price using Regular Pricing
        double regularPrice = regularStrategy.calculatePrice(basePrice);
        System.out.println("Regular Price: $" + regularPrice);

        // Calculate price using Seasonal Pricing
        double seasonalPrice = seasonalStrategy.calculatePrice(basePrice);
        System.out.println("Seasonal Price: $" + seasonalPrice);
    }
}
