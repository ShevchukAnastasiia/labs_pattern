package factorymethod;
import java.util.List;
import java.util.function.Predicate;

record Car(String model, double price, boolean isElectric) {}

public class StrategyMain {

    // Класичний метод (без стратегії) - рахуємо всі машини
    public static double totalAllCarsValue(List<Car> cars) {
        double total = 0;
        for (Car car : cars) {
            total += car.price();
        }
        return total;
    }

    // СУЧАСНИЙ МЕТОД ЗІ СТРАТЕГІЄЮ (через Predicate)
    public static double totalCarValue(List<Car> cars, Predicate<Car> selector) {
        double total = 0;
        for (Car car : cars) {
            // Перевіряємо, чи підходить машина під нашу стратегію
            if (selector.test(car)) {
                total += car.price();
            }
        }
        return total;
    }

    // Окремий метод, який можна передати як Reference (Method Reference)
    public static boolean isPremium(Car car) {
        return car.price() > 50000;
    }

    public static void main(String[] args) {
        var showroom = List.of(
                new Car("Nissan Leaf", 25000, true),
                new Car("Tesla Model S", 80000, true),
                new Car("BMW X5", 60000, false),
                new Car("Toyota Corolla", 20000, false)
        );

        System.out.println("--- Розрахунок вартості автосалону ---");

        // Стратегія 1: Рахуємо всі авто (лямбда завжди повертає true)
        System.out.println("Всі авто: $" + totalCarValue(showroom, car -> true));

        // Стратегія 2: Рахуємо тільки електрокари (лямбда перевіряє isElectric)
        System.out.println("Тільки електрокари: $" + totalCarValue(showroom, Car::isElectric));

        // Стратегія 3: Рахуємо тільки авто з ДВЗ (лямбда перевіряє !isElectric)
        System.out.println("Тільки ДВЗ: $" + totalCarValue(showroom, car -> !car.isElectric()));

        // Стратегія 4: Рахуємо преміум авто (передаємо посилання на метод)
        System.out.println("Преміум авто (>50k): $" + totalCarValue(showroom, StrategyMain::isPremium));
    }
}