package behavioral.strategy;

@FunctionalInterface
public interface TripCostStrategy {
    // Розрахувати ціну на основі дистанції
    double calculate(int distanceKm);
}