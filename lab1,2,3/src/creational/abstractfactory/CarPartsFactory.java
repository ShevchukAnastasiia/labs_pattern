package creational.abstractfactory;

public interface CarPartsFactory {
    Engine createEngine();
    Body createBody();
    Wheels createWheels();
}