package behavioral.mediator.systems;

import behavioral.mediator.VehicleAction;
import behavioral.mediator.CarControlCenter;

public interface CarSystem {
    void joinedControlCenter(CarControlCenter controlCenter);
    void receiveEvent(VehicleAction action);
    void triggerEvent(VehicleAction action);
}