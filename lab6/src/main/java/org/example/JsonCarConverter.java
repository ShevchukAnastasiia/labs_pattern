package org.example;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class JsonCarConverter {
    @Inject
    public JsonCarConverter() {}

    public List<Car> parseCars(String response) {
        System.out.println("Парсинг JSON даних про імпортовані авто...");
        var cars = new ArrayList<Car>();
        cars.add(new Car(3,"Tesla Model 3"));
        return cars;
    }
}
