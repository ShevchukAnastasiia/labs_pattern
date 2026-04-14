package tasks;

import java.util.List;

public class Task11 {
    public static void main(String[] args) {
        List<String> cities = List.of("Kyiv", "Chernivtsi", "Lviv");
        System.out.println("Всі з великої: " + checkAllUpper(cities));
    }

    public static boolean checkAllUpper(List<String> list) {
        return list.stream()
                .allMatch(s -> s.length() > 0 && Character.isUpperCase(s.charAt(0)));
    }
}
