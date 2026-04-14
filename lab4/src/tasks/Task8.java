package tasks;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task8 {
    public static void main(String[] args) {
        List<String> words = List.of("Java", "Python", "C", "JavaScript");
        System.out.println("Сортування за довжиною: " + sortByLength(words));
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
