package creational.builder;

public enum Transmission {
    MANUAL, AUTOMATIC, ROBOTIC;

    @Override
    public String toString() { return name().toLowerCase(); }
}
