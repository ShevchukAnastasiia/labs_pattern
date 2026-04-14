package behavioral.mediator;

import behavioral.mediator.systems.CarSystem; // ВАЖЛИВО: імпортуємо новий тип

public interface CarControlCenter {
    // Тепер методи чекають на CarSystem
    void registerComponent(CarSystem system);
    void coordinate(CarSystem sender, VehicleAction action);
}