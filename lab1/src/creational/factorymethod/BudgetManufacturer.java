package creational.factorymethod;

import java.util.EnumMap;
import java.util.Map;

public class BudgetManufacturer implements VehicleManufacturer {
    private static final Map<VehicleType, BudgetVehicle> ARSENAL;

    static {
        ARSENAL = new EnumMap<>(VehicleType.class);
        for (VehicleType type : VehicleType.values()) {
            ARSENAL.put(type, new BudgetVehicle(type));
        }
    }

    @Override
    public Vehicle manufactureVehicle(VehicleType vehicleType) {
        return ARSENAL.get(vehicleType);
    }

    @Override
    public String toString() {
        return "Виробник бюджетних авто";
    }
}