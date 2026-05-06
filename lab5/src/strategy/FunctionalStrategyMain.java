package strategy;
import java.util.function.DoubleUnaryOperator;

class TaxiOrder {
    // Вбудований інтерфейс замість старого TripCostStrategy
    private final DoubleUnaryOperator costStrategy;

    public TaxiOrder(DoubleUnaryOperator costStrategy) {
        this.costStrategy = costStrategy;
    }

    public double calculateFinalPrice(double distance) {
        return costStrategy.applyAsDouble(distance); // Застосовуємо формулу
    }
}

public class FunctionalStrategyMain {
    public static void main(String[] args) {
        // Оголошуємо всі стратегії прямо тут через лямбди
        DoubleUnaryOperator economy = dist -> dist * 15.0;
        DoubleUnaryOperator premium = dist -> dist * 30.0 + 100.0;
        DoubleUnaryOperator cargo   = dist -> dist * 50.0 + 200.0;

        double distance = 10.0;

        TaxiOrder order1 = new TaxiOrder(economy);
        System.out.println("Економ (10 км): " + order1.calculateFinalPrice(distance) + " грн");

        TaxiOrder order2 = new TaxiOrder(premium);
        System.out.println("Преміум (10 км): " + order2.calculateFinalPrice(distance) + " грн");
    }
}