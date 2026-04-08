package structural.flyweight;

import java.util.List;

public class CarShowroom {
    private final List<Wheel> carLotA;
    private final List<Wheel> carLotB;

    public CarShowroom(List<Wheel> lotA, List<Wheel> lotB) {
        this.carLotA = lotA;
        this.carLotB = lotB;
    }

    public void displayCars() {
        System.out.println("Обслуговування машин на майданчику А:");
        carLotA.forEach(Wheel::install);
        System.out.println("\nОбслуговування машин на майданчику Б:");
        carLotB.forEach(Wheel::install);
    }
}