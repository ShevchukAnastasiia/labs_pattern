package behavioral.mediator.systems;

import behavioral.mediator.VehicleAction;
import behavioral.mediator.CarControlCenter;

public abstract class CarSystemBase implements CarSystem {

    protected CarControlCenter controlCenter;

    @Override
    public void joinedControlCenter(CarControlCenter controlCenter) {
        System.out.println("[Система] " + this + " підключена до центрального комп'ютера.");
        this.controlCenter = controlCenter;
    }

    @Override
    public void receiveEvent(VehicleAction action) {
        // Коли інша система щось зробила, ми реагуємо (аналог partyAction)
        System.out.println(this + " реагує: " + action.getDescription());
    }

    @Override
    public void triggerEvent(VehicleAction action) {
        // Коли ми самі щось робимо, ми сповіщаємо медіатор (аналог act)
        if (controlCenter != null) {
            System.out.println(this + " ініціює подію: " + action);
            controlCenter.coordinate(this, action);
        }
    }

    @Override
    public abstract String toString();
}