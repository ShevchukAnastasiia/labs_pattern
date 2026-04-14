package behavioral.strategy;

public class TaxiOrder {

    private TripCostStrategy strategy;

    public TaxiOrder(TripCostStrategy strategy) {
        this.strategy = strategy;
    }

    public void changeStrategy(TripCostStrategy strategy) {
        System.out.println("[Система] Тариф змінено.");
        this.strategy = strategy;
    }

    public void printFinalPrice(int distance) {
        double price = strategy.calculate(distance);
        System.out.println("Вартість поїздки на " + distance + " км складе: " + price + " грн.");
    }
}