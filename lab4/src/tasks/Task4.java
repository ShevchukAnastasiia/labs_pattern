package tasks;

import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("Сума парних: " + sumOfEvens(numbers));
    }

    public static int sumOfEvens(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }
}