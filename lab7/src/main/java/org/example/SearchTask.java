package org.example;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class SearchTask {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Завдання 6.1: Пошуковий рядок (debounce) ===");

        Observable<String> keystrokes = Observable.create(emitter -> {
            String[] inputs = {"К", "Ки", "Киї", "Київ", "Київ ", "Київ К", "Київ Ки"};
            // Затримки між натисканнями клавіш у мілісекундах
            long[] delays = {50, 80, 120, 100, 400, 60, 350};

            for (int i = 0; i < inputs.length; i++) {
                emitter.onNext(inputs[i]);
                Thread.sleep(delays[i]); // Імітуємо реальну швидкість друкування
            }
            emitter.onComplete();
        });

        keystrokes
                .debounce(300, TimeUnit.MILLISECONDS)
                .subscribe(
                        result -> System.out.println("[ПОШУК] Запит до АРІ: \"" + result + "\"")
                );

        Thread.sleep(1500);
    }
}