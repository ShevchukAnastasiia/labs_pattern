package behavioral.mediator;

public enum VehicleAction {
    // 1. КОНСТАНТИ ПЕРШИМИ (через кому, в кінці крапка з комою)
    ACCELERATE("збільшує швидкість", "оптимізує подачу пального"),
    BRAKE("тисне на гальма", "вмикає стоп-сигнали"),
    OBSTACLE_DETECTED("виявив перешкоду", "готується до екстреного маневру"),
    NONE("", "");

    // 2. ПОЛЯ ПІСЛЯ КОНСТАНТ
    private final String title;
    private final String description;

    // 3. КОНСТРУКТОР
    VehicleAction(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getDescription() { return description; }

    @Override
    public String toString() { return title; }
}