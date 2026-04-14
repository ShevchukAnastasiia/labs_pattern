package tasks;

import java.util.stream.LongStream;

public class Task5 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Факторіал " + n + " = " + calculateFactorial(n));
    }

    public static long calculateFactorial(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }
}
