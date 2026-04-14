package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class CarOrder {

    private StatusType currentStatus;
    private final List<StatusObserver> observers;

    public CarOrder() {
        observers = new ArrayList<>();
        currentStatus = StatusType.ORDERED;
    }

    public void addObserver(StatusObserver obs) {
        observers.add(obs);
    }

    public void removeObserver(StatusObserver obs) {
        observers.remove(obs);
    }

    // Аналог timePasses - перехід на наступний етап
    public void nextStep() {
        var enumValues = StatusType.values();
        currentStatus = enumValues[(currentStatus.ordinal() + 1) % enumValues.length];
        System.out.println("\n[Завод] Статус замовлення змінено на: " + currentStatus.description);
        notifyObservers();
    }

    private void notifyObservers() {
        for (var obs : observers) {
            obs.update(currentStatus);
        }
    }
}