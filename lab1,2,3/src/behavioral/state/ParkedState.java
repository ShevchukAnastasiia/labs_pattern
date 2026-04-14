package behavioral.state;

public class ParkedState implements VehicleState {

    private final AutonomousCar car;

    public ParkedState(AutonomousCar car) {
        this.car = car;
    }

    @Override
    public void displayStatus() {
        System.out.println(car + " зараз у режимі паркування. Двері заблоковано, двигун вимкнено.");
    }

    @Override
    public void onActivate() {
        System.out.println(car + " переходить у режим спокою. Активується ручне гальмо.");
    }
}