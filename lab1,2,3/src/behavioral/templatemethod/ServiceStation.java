package behavioral.templatemethod;

public class ServiceStation {
    private CarMaintenanceProcess process;

    public ServiceStation(CarMaintenanceProcess process) {
        this.process = process;
    }

    public void maintain() {
        process.processVehicle();
    }

    public void setProcess(CarMaintenanceProcess process) {
        this.process = process;
    }
}