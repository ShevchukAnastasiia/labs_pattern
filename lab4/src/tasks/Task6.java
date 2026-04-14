package tasks;

import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println("Множення: " + multiplyElements(numbers));
        System.out.println("Додавання: " + sumElements(numbers));
    }

    public static int multiplyElements(List<Integer> list) {
        return list.stream().reduce(1, (a, b) -> a * b);
    }

    public static int sumElements(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}