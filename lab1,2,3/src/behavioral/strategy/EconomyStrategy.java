package behavioral.strategy;

public class EconomyStrategy implements TripCostStrategy {
    @Override
    public double calculate(int distanceKm) {
        return distanceKm * 10.5; // Базовий тариф
    }
}