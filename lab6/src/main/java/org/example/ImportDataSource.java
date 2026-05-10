package org.example;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImportDataSource {
    private final JsonCarConverter jsonCarConverter;
    private final CustomsClient customsClient;

    @Inject
    public ImportDataSource(JsonCarConverter jsonCarConverter, CustomsClient customsClient) {
        this.jsonCarConverter = jsonCarConverter;
        this.customsClient = customsClient;
    }

    public Optional<List<Car>> getImportedCars() {
        var response = customsClient.get("/import/cars").orElse("");
        if (response.isEmpty()) {
            return Optional.of(new ArrayList<>());
        }
        return Optional.of(jsonCarConverter.parseCars(response));
    }
}
