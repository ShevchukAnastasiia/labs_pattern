package tasks;

import java.util.List;

public class Task13 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 4, 9, 2, 8, 7);
        System.out.println("Найбільше парне: " + findMaxEven(nums));
    }

    public static Integer findMaxEven(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compare)
                .orElse(null);
    }
}
