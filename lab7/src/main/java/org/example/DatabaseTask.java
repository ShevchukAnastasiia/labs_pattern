package org.example;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class DatabaseTask {
    public static Maybe<String> findInCache(String key) {
        return switch (key) {
            case "user:1" -> Maybe.just("{'name': 'Леся', 'age':28}");
            case "user:2" -> Maybe.empty(); // Нічого немає (кеш-міс)
            case "user:error" -> Maybe.error(new RuntimeException("Redis недоступний"));
            default -> Maybe.empty();
        };
    }

    public static void testCache(String key) {
        findInCache(key)
                .defaultIfEmpty("Завантажено з БД")
                .subscribe(
                        result -> {
                            if (result.equals("Завантажено з БД")) {
                                System.out.println("[КЕШ (-)] Кеш-міс. Значення: " + result);
                            } else {
                                System.out.println("[КЕШ (+)] Знайдено: " + result);
                            }
                        },
                        error -> System.out.println("[КЕШ (!)] Помилка: " + error.getMessage())
                );
    }

    public static Completable validateInput() {
        return Completable.fromAction(() -> {
            System.out.println("[ПОШУК] Перевірка даних...");
            System.out.println("(+) Дані валідні");
        });
    }

    public static Completable saveToDatabase() {
        return Completable.fromAction(() -> {
            System.out.println("[DB] Збереження в БД...");
            System.out.println("(+) Збережено");
        });
    }

    public static Single<String> generateToken() {
        return Single.fromCallable(() -> {
            String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.demo";
            System.out.println("[ТОКЕН] Токен: " + token);
            return token; // Single завжди має щось повернути
        });
    }


    public static void main(String[] args) {
        System.out.println("=== ЧАСТИНА А: Maybe ===");
        testCache("user:1");
        testCache("user:2");
        testCache("user:error");

        System.out.println("\n=== ЧАСТИНА В: Completable + andThen() ===");

        validateInput()
                .andThen(saveToDatabase()) // andThen з'єднує Completable
                .andThen(generateToken())
                .subscribe(
                        token -> System.out.println("(+) Реєстрацію завершено успішно!"),
                        error -> System.out.println("(-) Помилка: " + error.getMessage())
                );
    }
}