package tasks;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Double> values = List.of(10.0, 20.0, 30.0, 40.0);
        System.out.println("Середнє значення: " + getAverage(values));
    }

    public static double getAverage(List<Double> list) {
        return list.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }
}