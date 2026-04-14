package tasks;

import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) {
        String sentence = "Java Lambda Stream API Laboratory";
        System.out.println("Кількість слів: " + countWordsInSentence(sentence));
    }

    public static long countWordsInSentence(String sentence) {
        return Arrays.stream(sentence.trim().split("\\s+"))
                .count();
    }
}
