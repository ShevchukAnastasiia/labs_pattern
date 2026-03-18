package creational.builder;

public enum BodyType {
    SEDAN, SUV, COUPE, HATCHBACK;

    @Override
    public String toString() { return name().toLowerCase(); }
}
