package org.example;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class FactoryDataSource {
    private final AssemblyLine assemblyLine;
    private final CarConverter carConverter;

    @Inject
    public FactoryDataSource(AssemblyLine assemblyLine, CarConverter carConverter) {
        this.assemblyLine = assemblyLine;
        this.carConverter = carConverter;
    }

    public Optional<List<Car>> selectAllCars() {
        assemblyLine.start();
        return Optional.of(carConverter.toCarList());
    }
}
