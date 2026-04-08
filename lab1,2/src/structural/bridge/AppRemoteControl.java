package structural.bridge;

public class AppRemoteControl implements VehicleControl {
    private final DriveMode driveMode;

    public AppRemoteControl(DriveMode driveMode) {
        this.driveMode = driveMode;
    }

    @Override
    public void engage() {
        System.out.println("Додаток підключено до авто.");
        driveMode.onActivate();
    }

    @Override
    public void move() {
        System.out.println("Машина керується дистанційно через смартфон.");
        driveMode.onExecute();
    }

    @Override
    public void release() {
        System.out.println("Сесія в додатку завершена.");
        driveMode.onDeactivate();
    }

    @Override
    public DriveMode getDriveMode() { return driveMode; }
}