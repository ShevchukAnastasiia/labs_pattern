import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// 1. EXECUTE AROUND (Діагностика авто)
class DiagnosticScanner {
    private DiagnosticScanner() {
        System.out.println(">> [СТАРТ] Підключення сканера OBD-II...");
    }

    public static void use(Consumer<DiagnosticScanner> block) {
        DiagnosticScanner scanner = new DiagnosticScanner();
        try {
            block.accept(scanner);
        } finally {
            scanner.close();
        }
    }

    public DiagnosticScanner scanEngine() {
        System.out.println("   [Операція] Перевірка тиску в циліндрах...");
        return this;
    }

    public DiagnosticScanner checkBattery() {
        System.out.println("   [Операція] Діагностика високовольтної батареї...");
        return this;
    }

    private void close() {
        System.out.println(">> [ФІНІШ] Відключення сканера. Логи збережено.\n");
    }
}

// 2. DEFAULT FACTORY METHOD (Виробництво)

interface Vehicle {
    void drive();
}

class PremiumVehicle implements Vehicle {
    public void drive() { System.out.println("   Їдемо з комфортом (Преміум)"); }
}

class BudgetVehicle implements Vehicle {
    public void drive() { System.out.println("   Їдемо економно (Бюджет)"); }
}

@FunctionalInterface
interface VehicleManufacturer {
    Vehicle createVehicle(); // Абстрактний фабричний метод

    default void deliverAndTest() {
        Vehicle v = createVehicle();
        v.drive();
    }
}

// 3. STRATEGY (Розрахунок вартості автосалону)

record CarForSale(String model, double price, boolean isElectric) {}


// 4. DECORATOR (Тюнінг через композицію)

record TunedCar(String description, double price) {}


public class Main {

    // Метод для патерну Strategy
    public static double totalCarValue(List<CarForSale> cars, Predicate<CarForSale> selector) {
        double total = 0;
        for (CarForSale car : cars) {
            if (selector.test(car)) {
                total += car.price();
            }
        }
        return total;
    }

    public static void main(String[] args) {

        System.out.println("=== 1. ПАТЕРН: EXECUTE AROUND ===");
        DiagnosticScanner.use(scanner -> scanner.scanEngine());
        DiagnosticScanner.use(scanner -> scanner.checkBattery());


        System.out.println("=== 2. ПАТЕРН: DEFAULT FACTORY METHOD ===");
        // Передаємо посилання на конструктори замість створення класів-фабрик
        VehicleManufacturer premiumFactory = PremiumVehicle::new;
        VehicleManufacturer budgetFactory = BudgetVehicle::new;

        premiumFactory.deliverAndTest();
        budgetFactory.deliverAndTest();
        System.out.println();


        System.out.println("=== 3. ПАТЕРН: STRATEGY (через Predicate) ===");
        var showroom = List.of(
                new CarForSale("Nissan Leaf", 25000, true),
                new CarForSale("Tesla Model S", 80000, true),
                new CarForSale("BMW X5", 60000, false)
        );

        System.out.println("   Всі авто: $" + totalCarValue(showroom, car -> true));
        System.out.println("   Тільки електро: $" + totalCarValue(showroom, CarForSale::isElectric));
        System.out.println("   Тільки ДВЗ: $" + totalCarValue(showroom, car -> !car.isElectric()));
        System.out.println();


        System.out.println("=== 4. ПАТЕРН: DECORATOR (через Function) ===");
        TunedCar basicCar = new TunedCar("Базове авто", 20000);

        // Декоратори як звичайні функції
        Function<TunedCar, TunedCar> addSportPack = car ->
                new TunedCar(car.description() + " + Спорт-пакет", car.price() + 5000);

        Function<TunedCar, TunedCar> addArmor = car ->
                new TunedCar(car.description() + " + Броня", car.price() + 15000);

        // Композиція: зліплюємо дві функції в одну
        Function<TunedCar, TunedCar> fullyLoadedFactory = addSportPack.andThen(addArmor);

        TunedCar finalCar = fullyLoadedFactory.apply(basicCar);
        System.out.println("   Було: " + basicCar.description() + " ($" + basicCar.price() + ")");
        System.out.println("   Стало: " + finalCar.description() + " ($" + finalCar.price() + ")");
    }
}