package tasks;

import java.util.List;

public class Task10 {
    public static void main(String[] args) {
        List<String> list = List.of("", "   ", "Hello", "World");
        System.out.println("Перший непорожній: " + findFirstNonEmpty(list));
    }

    public static String findFirstNonEmpty(List<String> list) {
        return list.stream()
                .filter(s -> !s.trim().isEmpty())
                .findFirst()
                .orElse("Не знайдено");
    }
}