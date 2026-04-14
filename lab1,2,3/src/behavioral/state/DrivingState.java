package behavioral.state;

public class DrivingState implements VehicleState {

    private final AutonomousCar car;

    public DrivingState(AutonomousCar car) {
        this.car = car;
    }

    @Override
    public void displayStatus() {
        System.out.println(car + " мчить по трасі! Системи автопілота активні.");
    }

    @Override
    public void onActivate() {
        System.out.println(car + " починає рух! Сканування дороги запущено.");
    }
}