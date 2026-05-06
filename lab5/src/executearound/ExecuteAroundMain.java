package executearound;

import java.util.function.Consumer;

class DiagnosticScanner {

    // 1. Приватний конструктор: ніхто не зможе викликати new DiagnosticScanner()
    private DiagnosticScanner() {
        System.out.println(">> [СТАРТ] Підключення сканера OBD-II до порту автомобіля...");
    }

    // 2. Статичний метод use() - єдина точка входу
    public static void use(Consumer<DiagnosticScanner> block) {
        DiagnosticScanner scanner = new DiagnosticScanner(); // Відкриваємо ресурс
        try {
            block.accept(scanner); // Виконуємо унікальну логіку користувача
        } finally {
            scanner.close(); // Гарантовано закриваємо ресурс, навіть якщо була помилка
        }
    }

    // 3. Операції повертають 'this' для створення "ланцюжка" (Fluent Interface)
    public DiagnosticScanner scanEngine() {
        System.out.println("   [Операція] Перевірка тиску в циліндрах двигуна...");
        return this;
    }

    public DiagnosticScanner checkBattery() {
        System.out.println("   [Операція] Діагностика стану високовольтної батареї...");
        return this;
    }

    public DiagnosticScanner clearErrors() {
        System.out.println("   [Операція] Скидання знайдених помилок у пам'яті (DTC)...");
        return this;
    }

    // 4. Приватний метод close: його не можна викликати вручну ззовні
    private void close() {
        System.out.println(">> [ФІНІШ] Відключення сканера. Збереження логів.\n");
    }
}

public class ExecuteAroundMain {

    public static void main(String[] args) {
        System.out.println("--- Діагностика BMW (ДВЗ) ---");
        // Передаємо лямбду. Ресурс сам відкриється і сам закриється.
        DiagnosticScanner.use(scanner -> scanner
                .scanEngine()
                .clearErrors()
        );

        System.out.println("--- Діагностика Tesla (Електро) ---");
        // Інша машина - інший ланцюжок дій
        DiagnosticScanner.use(scanner -> scanner
                .checkBattery()
                .clearErrors()
        );
    }
}