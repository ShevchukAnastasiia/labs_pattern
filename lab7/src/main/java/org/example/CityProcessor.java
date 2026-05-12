package org.example;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CityProcessor {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Київ", "Харків", "Одеса", "Дніпро", "Запоріжжя",
                "Кривий Ріг", "Миколаїв", "Херсон", "Кропивницький",
                "Черкаси", "Суми", "Хмельницький", "Чернівці", "Каховка");

        System.out.println("=== 1. Імперативний підхід (for-loop) ===");
        List<String> filteredCities = new ArrayList<>();
        for (String city : cities) {
            if (city.startsWith("К")) {
                filteredCities.add(city.toUpperCase());
            }
        }
        Collections.sort(filteredCities);
        for (String city : filteredCities) {
            System.out.println(city);
        }

        System.out.println("\n=== 2. Функціональний підхід (Java Streams) ===");
        cities.stream()
                .filter(city -> city.startsWith("К"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n=== 3. Реактивний підхід (RxJava) ===");
        Observable.fromIterable(cities)
                .filter(city -> city.startsWith("К"))
                .map(String::toUpperCase)
                .sorted()
                .subscribe(System.out::println);
    }
}
