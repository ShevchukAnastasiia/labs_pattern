package creational.factorymethod;

public record BudgetVehicle(VehicleType vehicleType) implements Vehicle {
    @Override
    public String toString() {
        return "бюджетний " + vehicleType;
    }
}