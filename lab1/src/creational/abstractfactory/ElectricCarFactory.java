package creational.abstractfactory;

public class ElectricCarFactory implements CarPartsFactory {
    @Override public Engine createEngine() { return new ElectricEngine(); }
    @Override public Body createBody() { return new ElectricBody(); }
    @Override public Wheels createWheels() { return new ElectricWheels(); }
}