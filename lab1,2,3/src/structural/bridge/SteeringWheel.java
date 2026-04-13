package structural.bridge;

public class SteeringWheel implements VehicleControl {
    private final DriveMode driveMode;

    public SteeringWheel(DriveMode driveMode) {
        this.driveMode = driveMode;
    }

    @Override
    public void engage() {
        System.out.println("Водій взявся за кермо.");
        driveMode.onActivate();
    }

    @Override
    public void move() {
        System.out.println("Машина керується через кермо.");
        driveMode.onExecute();
    }

    @Override
    public void release() {
        System.out.println("Водій відпустив кермо.");
        driveMode.onDeactivate();
    }

    @Override
    public DriveMode getDriveMode() { return driveMode; }
}