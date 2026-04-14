package behavioral.iterator;

public class Car {
    private CarType type;
    private final String model;

    public Car(CarType type, String model) {
        this.type = type;
        this.model = model;
    }

    public CarType getType() { return type; }

    @Override
    public String toString() { return model; }
}