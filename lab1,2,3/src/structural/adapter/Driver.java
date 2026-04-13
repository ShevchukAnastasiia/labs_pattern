package structural.adapter;

public class Driver {
    private final Drivable Vehicle;

    public Driver(Drivable Vehicle) {
        this.Vehicle = Vehicle;
    }

    public void startJourney() {
        Vehicle.drive();
    }
}
