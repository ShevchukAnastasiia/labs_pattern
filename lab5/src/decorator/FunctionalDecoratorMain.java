package decorator;
import java.util.function.Function;

// Базовий об'єкт (незмінний record замість важкого класу)
record Car(String description, double price) {}

public class FunctionalDecoratorMain {
    public static void main(String[] args) {
        // Базове авто
        Car basicCar = new Car("Базова комплектація", 20000);

        // Наші декоратори як звичайні функції
        Function<Car, Car> addSportPack = car ->
                new Car(car.description() + " + Спорт-пакет", car.price() + 5000);

        Function<Car, Car> addArmor = car ->
                new Car(car.description() + " + Броня", car.price() + 15000);

        // Композиція (зліплюємо функції). Спочатку спорт, потім броня.
        Function<Car, Car> fullyLoadedFactory = addSportPack.andThen(addArmor);

        // Застосовуємо створений мега-декоратор до базового авто
        Car finalCar = fullyLoadedFactory.apply(basicCar);

        System.out.println("Комплектація: " + finalCar.description());
        System.out.println("Загальна ціна: $" + finalCar.price());
    }
}