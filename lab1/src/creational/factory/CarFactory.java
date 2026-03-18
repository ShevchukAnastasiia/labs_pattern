package creational.factory;

public class CarFactory {

    public static Car createCar(CarType carType) {
        return switch (carType) {
            case SEDAN -> new SedanCar();
            case SUV -> new SuvCar();
            case TRUCK -> new TruckCar();
            default -> throw new IllegalArgumentException("Невідомий тип автомобіля");
        };
    }
}