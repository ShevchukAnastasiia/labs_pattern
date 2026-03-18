package creational.builder;

public enum EngineType {
    GASOLINE, DIESEL, ELECTRIC, HYBRID;

    @Override
    public String toString() { return name().toLowerCase(); }
}