package behavioral.state;

public class AutonomousCar {

    private VehicleState state;

    public AutonomousCar() {
        // Початковий стан — паркування
        state = new ParkedState(this);
    }

    public void toggleMode() {
        // Логіка перемикання (аналог timePasses)
        if (state.getClass().equals(ParkedState.class)) {
            changeStateTo(new DrivingState(this));
        } else {
            changeStateTo(new ParkedState(this));
        }
    }

    private void changeStateTo(VehicleState newState) {
        this.state = newState;
        this.state.onActivate();
    }

    @Override
    public String toString() {
        return "Автопілот Tesla";
    }

    public void showDashboard() {
        this.state.displayStatus();
    }
}