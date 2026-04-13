package structural.bridge;

public interface DriveMode {
    void onActivate();
    void onExecute();
    void onDeactivate();
}