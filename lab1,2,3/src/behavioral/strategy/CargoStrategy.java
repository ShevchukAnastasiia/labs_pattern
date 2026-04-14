package behavioral.strategy;

public class CargoStrategy implements TripCostStrategy {
    @Override
    public double calculate(int distanceKm) {
        return distanceKm * 40.0; // Вантажний тариф
    }
}