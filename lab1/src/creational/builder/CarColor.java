package creational.builder;

public enum CarColor {
    WHITE, BLACK, RED, BLUE, SILVER;

    @Override
    public String toString() { return name().toLowerCase(); }
}
