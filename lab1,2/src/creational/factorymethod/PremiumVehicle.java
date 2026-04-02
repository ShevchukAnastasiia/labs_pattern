package creational.factorymethod;

public record PremiumVehicle(VehicleType vehicleType) implements Vehicle {
    @Override
    public String toString() {
        return "преміальний " + vehicleType;
    }
}