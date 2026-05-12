package org.example;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class StadiumTask {
    public static void main(String[] args) throws InterruptedException {

        String[] results = {
                "Динамо 2:1 Шахтар",
                "Шахтар 3:0 Металіст",
                "Зоря 1:1 Ворскла",
                "Дніпро-1 2:0 Рух",
                "Колос 0:0 Чорноморець"
        };

        System.out.println("=== ЧАСТИНА А: Холодний Observable (Запис матчів) ===");
        Observable<String> coldObservable = Observable.fromArray(results);

        coldObservable.subscribe(res -> System.out.println("[Холодний] Фанат 1 (дивиться запис): " + res));
        System.out.println("---");
        coldObservable.subscribe(res -> System.out.println("[Холодний] Фанат 2 (теж дивиться запис): " + res));

        System.out.println("\n=== ЧАСТИНА В: Гарячий Observable (Прямий ефір) ===");

        Observable<String> timedObservable = Observable.zip(
                Observable.fromArray(results),
                Observable.interval(1, TimeUnit.SECONDS),
                (match, tick) -> match
        );

        ConnectableObservable<String> hotObservable = timedObservable.publish();
        hotObservable.subscribe(res -> System.out.println("[Гарячий] Глядач 1 (на стадіоні):" + res));
        hotObservable.connect();
        Thread.sleep(2500);
        hotObservable.subscribe(res -> System.out.println("[Гарячий] Глядач 2 (запізнився):" + res));
        Thread.sleep(3500);
    }
}
