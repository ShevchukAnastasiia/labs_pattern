package org.example;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AppCarRepository implements CarRepository {
    private final ShowroomDataSource showroomDataSource;
    private final FactoryDataSource factoryDataSource;
    private final ImportDataSource importDataSource;

    @Inject
    public AppCarRepository(
            ShowroomDataSource showroomDataSource,
            FactoryDataSource factoryDataSource,
            ImportDataSource importDataSource

    ) {
        this.showroomDataSource = showroomDataSource;
        this.factoryDataSource = factoryDataSource;
        this.importDataSource = importDataSource;
    }

    @Override
    public List<Car> allCars() {
        var allCars = importDataSource.getImportedCars();
        if (allCars.isEmpty() || allCars.get().isEmpty()) {
            allCars = factoryDataSource.selectAllCars();
        }
        return allCars.orElse(new ArrayList<>());
    }
}

