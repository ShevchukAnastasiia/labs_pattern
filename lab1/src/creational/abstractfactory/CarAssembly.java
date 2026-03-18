package creational.abstractfactory;

public record CarAssembly(Engine engine, Body body, Wheels wheels) {

    public static class FactoryMaker {
        public static CarPartsFactory makeFactory(CarType type) {
            return switch (type) {
                case ELECTRIC -> new ElectricCarFactory();
                case GASOLINE -> new GasolineCarFactory();
            };
        }
    }
}
