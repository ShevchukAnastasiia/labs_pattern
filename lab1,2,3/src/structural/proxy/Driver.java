package structural.proxy;

public class Driver {
    private final String name;
    private final boolean hasKey;

    public Driver(String name, boolean hasKey) {
        this.name = name;
        this.hasKey = hasKey;
    }

    public boolean hasKey() {
        return hasKey;
    }

    @Override
    public String toString() {
        return name;
    }
}