package org.example;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CarConverter {
    @Inject
    public CarConverter() {}

    public List<Car> toCarList() {
        System.out.println("Конвертація деталей у готові авто...");
        var cars = new ArrayList<Car>();
        cars.add(new Car(1, "BMW X5"));
        cars.add(new Car(2, "Audi Q7"));
        return cars;
    }
}