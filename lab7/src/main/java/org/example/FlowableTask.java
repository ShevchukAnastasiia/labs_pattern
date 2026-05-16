package org.example;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.atomic.AtomicInteger;

public class FlowableTask {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== ЧАСТИНА А: buffer() (Пакетне збереження в БД) ===");

        Observable<String> events = Observable.fromArray(
                "LOGIN:user1", "CLICK:btn_buy", "VIEW:product_42", "LOGIN:user2",
                "LOGOUT:user1", "CLICK:btn_cart", "VIEW:product_7", "LOGIN:user3",
                "CLICK:btn_pay", "LOGOUT:user2", "LOGIN:user4", "VIEW:product_1"
        );

        AtomicInteger batchCounter = new AtomicInteger(1);
        AtomicInteger totalEvents = new AtomicInteger(0);

        events
                .buffer(5)
                .subscribe(batch -> {
                    System.out.println("[DB] Batch INSERT #" + batchCounter.getAndIncrement() + ": " + batch);
                    totalEvents.addAndGet(batch.size());
                });
        System.out.println("(+) Збережено подій: " + totalEvents.get() + "\n");


        System.out.println("=== ЧАСТИНА В: Flowable та BackpressureStrategy.DROP ===");

        Flowable<Integer> fastProducer = Flowable.range(1, 1000);

        AtomicInteger processed = new AtomicInteger(0);
        AtomicInteger dropped = new AtomicInteger(0);

        fastProducer
                .onBackpressureDrop(item -> dropped.incrementAndGet())
                .observeOn(Schedulers.io())
                .doOnNext(item -> {
                    Thread.sleep(10);
                    processed.incrementAndGet();
                })
                .blockingSubscribe(
                        item -> {}, // Нічого не виводимо на кожен елемент, щоб не спамити консоль
                        Throwable::printStackTrace,
                        () -> {
                            System.out.println("[ЗВІТ] Оброблено: ~" + processed.get());
                            System.out.println("[ЗВІТ] Відкинуто: ~" + dropped.get());
                            System.out.println("(!) Стратегія DROP: частину елементів втрачено");
                        }
                );
    }
}