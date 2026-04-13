package structural.composite;

import java.util.List;

public class CarManager {

    public CarPartComposite composeElectricCar() {
        // Створюємо дрібні деталі
        var engineParts = List.of(new Part("Ротор"), new Part("Статор"));
        var bodyParts = List.of(new Part("Двері"), new Part("Капот"), new Part("Багажник"));
        // Збираємо їх у вузли
        var engineAssembly = new Assembly("Електро двигун", engineParts);
        var bodyAssembly = new Assembly("Кузов", bodyParts);
        // Збираємо фінальне авто
        return new VehicleComposite("Audi E-tron", List.of(engineAssembly, bodyAssembly));
    }
}