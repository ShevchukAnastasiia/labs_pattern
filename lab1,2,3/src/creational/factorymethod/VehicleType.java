package creational.factorymethod;

public enum VehicleType {
    SEDAN("седан"),
    SUV("позашляховик"),
    TRUCK("вантажівка");

    private final String title;

    VehicleType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}