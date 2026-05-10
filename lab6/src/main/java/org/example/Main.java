package org.example;

public class Main {
    public static void main(String[] args) {
        AppComponent component = DaggerAppComponent.create();

        CarRepository repository = component.carRepository();

        System.out.println("--- СИСТЕМА АВТОХОЛДИНГУ (Dagger DI) ---");

        var cars = repository.allCars();

        System.out.println("\nДоступні автомобілі:");
        for (Car car : cars) {
            System.out.println("- " + car.model() + " (ID: " + car.id() + ")");
        }
    }
}