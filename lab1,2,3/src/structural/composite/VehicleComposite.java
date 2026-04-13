package structural.composite;

import java.util.List;

public class VehicleComposite extends CarPartComposite {
    private final String modelName;

    public VehicleComposite(String modelName, List<Assembly> assemblies) {
        this.modelName = modelName;
        assemblies.forEach(this::add);
    }

    @Override
    protected void printBefore() {
        System.out.println("--- АВТОМОБІЛЬ: " + modelName + " ---");
    }

    @Override
    protected void printAfter() {
        System.out.println("\n--- Збірка завершена ---");
    }
}