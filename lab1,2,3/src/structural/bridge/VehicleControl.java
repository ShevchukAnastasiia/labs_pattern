package structural.bridge;

public interface VehicleControl {
    void engage();
    void move();
    void release();
    DriveMode getDriveMode();
}