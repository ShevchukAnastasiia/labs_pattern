package behavioral.observer;

public class Dealer implements StatusObserver {
    @Override
    public void update(StatusType currentStatus) {
        System.out.println("Логістика для дилера: Готуємо місце на складі. Статус: " + currentStatus.description);
    }
}