package tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<String> strings = List.of("Banana", "Apple", "Orange", "Cherry");
        System.out.println("Відсортовано: " + sortAlphabetically(strings));
    }

    public static List<String> sortAlphabetically(List<String> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}