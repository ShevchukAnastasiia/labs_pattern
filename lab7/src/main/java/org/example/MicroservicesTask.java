package org.example;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;

public class MicroservicesTask {
    record ServiceCall(String serviceName, int delayMs) {}

    public static void main(String[] args) {
        List<ServiceCall> services = Arrays.asList(
                new ServiceCall("UserService", 800),
                new ServiceCall("OrderService", 1200),
                new ServiceCall("RecommendationService", 600)
        );

        System.out.println("=== Частина А: Послідовне завантаження (concatMap) ===");
        long startSeq = System.currentTimeMillis();

        Observable.fromIterable(services)
                .concatMap(service -> Observable.just(service)
                        .map(s -> {
                            Thread.sleep(s.delayMs()); // Імітуємо очікування відповіді
                            return String.format("[main] (+) %s відповів за %d мс", s.serviceName(), s.delayMs());
                        }))
                // blockingSubscribe зупиняє програму, поки потік не завершиться (щоб не писати Thread.sleep у main)
                .blockingSubscribe(System.out::println);

        long endSeq = System.currentTimeMillis();
        System.out.println("Загальний час (послідовно): ~" + (endSeq - startSeq) + " мс\n");


        System.out.println("=== Частина В: Паралельне завантаження (flatMap + Schedulers.io()) ===");
        long startPar = System.currentTimeMillis();

        Observable.fromIterable(services)
                .flatMap(service -> Observable.just(service)
                        .subscribeOn(Schedulers.io())
                        .map(s -> {
                            Thread.sleep(s.delayMs());
                            String threadName = Thread.currentThread().getName()
                                    .replace("RxCachedThreadScheduler-", "io-");
                            return String.format("[%s] (+) %s відповів за %d мс", threadName, s.serviceName(), s.delayMs());
                        }))
                .blockingSubscribe(System.out::println);

        long endPar = System.currentTimeMillis();
        System.out.println("Загальний час (паралельно): ~" + (endPar - startPar) + " мс");
    }
}