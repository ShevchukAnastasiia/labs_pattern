package behavioral.observer;

public class Customer implements StatusObserver {
    private final String name;

    public Customer(String name) { this.name = name; }

    @Override
    public void update(StatusType currentStatus) {
        System.out.println("Повідомлення для клієнта " + name + ": Ваш статус оновлено до '" + currentStatus.description + "'");
    }
}