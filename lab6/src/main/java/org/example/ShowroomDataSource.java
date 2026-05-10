package org.example;

import javax.inject.Inject;

public class ShowroomDataSource {
    private final GarageAccess garageAccess;
    private final JsonCarConverter jsonCarConverter;

    @Inject
    public ShowroomDataSource(GarageAccess garageAccess, JsonCarConverter jsonCarConverter) {
        this.garageAccess = garageAccess;
        this.jsonCarConverter = jsonCarConverter;
    }
}
