package org.example;

import io.reactivex.rxjava3.core.Observable;

public class CurrencyTask {
    public static void main(String[] args) {

        System.out.println("=== Завдання 7.1: Обробка помилок (Конвертер) ===");

        // Створюємо сервіс, який на середині падає з помилкою
        Observable<String> currencyService = Observable.create(emitter -> {
            emitter.onNext("USD -> UAH: 41.50");
            emitter.onNext("EUR -> UAH: 44.20");
            emitter.onError(new RuntimeException("Сервіс тимчасово недоступний"));
            emitter.onNext("GBP -> UAH: 52.10"); // Цей рядок ніколи не виконається
        });

        System.out.println("--- Сценарій А: onErrorReturn ---");
        currencyService
                // При помилці повертаємо одне дефолтне значення
                .onErrorReturn(error -> "Використовується кешований курс: USD -> UAH: 41.00")
                .subscribe(System.out::println);


        System.out.println("\n--- Сценарій В: onErrorResumeNext ---");
        currencyService
                // При помилці перемикаємося на резервний потік
                .onErrorResumeNext(error -> Observable.just("JPY -> UAH: 0.27", "PLN -> UAH: 10.30"))
                .subscribe(System.out::println);
    }
}