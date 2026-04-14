package behavioral.strategy;

public class PremiumStrategy implements TripCostStrategy {
    @Override
    public double calculate(int distanceKm) {
        return (distanceKm * 25.0) + 50.0; // Тариф з подачею преміум-авто
    }
}