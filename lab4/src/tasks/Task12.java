package tasks;

import java.util.Comparator;
import java.util.List;

public class Task12 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 5, 20, 20, 15);
        System.out.println("Друге за величиною: " + findSecondLargest(nums));
    }

    public static Integer findSecondLargest(List<Integer> list) {
        return list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }
}