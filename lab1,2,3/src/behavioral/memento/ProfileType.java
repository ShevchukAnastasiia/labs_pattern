package behavioral.memento;

public enum ProfileType {
    COMFORT("комфорт"),
    SPORT("спорт"),
    CITY("місто"),
    OFF_ROAD("бездоріжжя");

    private final String name;

    ProfileType(String name) { this.name = name; }

    @Override
    public String toString() { return name; }
}