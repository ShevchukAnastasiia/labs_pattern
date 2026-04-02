package structural.composite;

import java.util.List;

public class CarManager {

    public CarPartComposite composeDieselCar() {
        // Створюємо дрібні деталі
        var engineParts = List.of(new Part("Ротор"), new Part("Статор"));
        var bodyParts = List.of(new Part("Двері"), new Part("Капот"), new Part("Багажник"));
        // Збираємо їх у вузли
        var engineAssembly = new Assembly("Дизельний двигун", engineParts);
        var bodyAssembly = new Assembly("Кузов", bodyParts);
        // Збираємо фінальне авто
        return new VehicleComposite("Audi A6", List.of(engineAssembly, bodyAssembly));
    }
}