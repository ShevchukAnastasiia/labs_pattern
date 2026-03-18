package creational.factory;

public class TruckCar implements Car {
    @Override
    public String getDescription() {
        return "Це Вантажівка. Призначена для перевезення важких вантажів.";
    }
}