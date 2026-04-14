package behavioral.mediator;

import behavioral.mediator.systems.CarSystem; // Імпортуємо новий інтерфейс
import java.util.ArrayList;
import java.util.List;

public class CentralComputer implements CarControlCenter {
    // Тепер список містить об'єкти типу CarSystem
    private final List<CarSystem> systems = new ArrayList<>();

    @Override
    public void registerComponent(CarSystem system) {
        systems.add(system);
        // Сповіщаємо систему, що вона тепер під контролем цього медіатора
        system.joinedControlCenter(this);
    }

    @Override
    public void coordinate(CarSystem sender, VehicleAction action) {
        for (var system : systems) {
            // Посередник передає подію всім, крім того, хто її створив
            if (!system.equals(sender)) {
                system.receiveEvent(action);
            }
        }
    }
}