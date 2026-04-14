package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public record CarShowroom(List<Car> cars) {

    public Iterator<Car> iterator(CarType carType) {
        return new CarShowroomIterator(this, carType);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}