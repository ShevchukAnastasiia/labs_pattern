package org.example;

import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FoodOrderTask  {
    record FoodOrder(String orderId, List<String> items)  {}
    public static void main(String[] args) throws InterruptedException {
        List<FoodOrder> orders = Arrays.asList(
                new FoodOrder("ZAM-01", Arrays.asList("Піца Маргарита", "Кола 0.5л")),
                new FoodOrder("ZAM-02", Arrays.asList("Борщ", "Вареники", "Компот")),
                new FoodOrder("ZAM-03", Arrays.asList("Суші-сет 20шт", "Місо-суп"))
        );

        System.out.println("=== ЧАСТИНА А: flatMap() (Плоский потік) ===");
        Observable.fromIterable(orders)
                .flatMap(order -> Observable.fromIterable(order.items()))
                .subscribe(item -> System.out.println(">> " + item));

        System.out.println("\n=== ЧАСТИНА В: flatMap() vs concatMap() ===");

        System.out.println("--- Тестуємо flatMap() ---");
        Observable.fromIterable(orders)
                .flatMap(order -> Observable.fromIterable(order.items())
                        .delay(500, TimeUnit.MILLISECONDS))
                .subscribe(item -> System.out.println("[flatMap] " + item));

        Thread.sleep(1000);

        System.out.println("\n--- Тестуємо concatMap() ---");
        Observable.fromIterable(orders)
                .concatMap(order -> Observable.fromIterable(order.items())
                        .delay(500, TimeUnit.MILLISECONDS))
                .subscribe(item -> System.out.println("[concatMap] " + item));

        Thread.sleep(3000);
    }
}
