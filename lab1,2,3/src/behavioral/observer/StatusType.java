package behavioral.observer;

public enum StatusType {
    ORDERED("Замовлення прийнято"),
    IN_PRODUCTION("Авто на конвеєрі"),
    READY_FOR_PICKUP("Авто чекає в салоні");

    public final String description;

    StatusType(String description) {
        this.description = description;
    }
}