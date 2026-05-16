package org.example;

import io.reactivex.rxjava3.core.Observable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryTask {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Завдання 7.2: retryWhen з експоненційним backoff ===");

        AtomicInteger attemptCount = new AtomicInteger(0);
        
        Observable<String> unstableApiCall = Observable.create(emitter -> {
            int attempt = attemptCount.incrementAndGet();
            System.out.println("[ПОВТОР] Спроба #" + attempt);

            if (attempt < 4) {
                emitter.onError(new IOException("Connection timeout"));
            } else {
                emitter.onNext("(+) Відповідь API: {status: 'ok', data: [...]}");
                emitter.onComplete();
            }
        });

        unstableApiCall
                .retryWhen(errors -> errors
                        .zipWith(Observable.range(1, 4), (error, attempt) -> attempt)
                        .flatMap(attempt -> {
                            long delay = (long) Math.pow(2, attempt - 1);
                            System.out.println("Очікуємо " + delay + " сек перед повтором...");
                            return Observable.timer(delay, TimeUnit.SECONDS);
                        })
                )
                .subscribe(System.out::println);

        Thread.sleep(8000);
    }
}