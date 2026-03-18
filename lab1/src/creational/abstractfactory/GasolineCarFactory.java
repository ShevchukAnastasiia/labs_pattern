package creational.abstractfactory;

public class GasolineCarFactory implements CarPartsFactory {
    @Override public Engine createEngine() { return new GasolineEngine(); }
    @Override public Body createBody() { return new GasolineBody(); }
    @Override public Wheels createWheels() { return new GasolineWheels(); }
}
