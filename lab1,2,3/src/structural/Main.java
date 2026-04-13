package structural;

import structural.adapter.*;
import structural.bridge.*;
import structural.composite.*;
import structural.decorator.*;
import structural.facade.*;
import structural.flyweight.*;
import structural.proxy.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("   LAb #2: СТРУКТУРНІ ПАТЕРНИ АВТОХОЛДИНГУ");

        // 1. FACADE (Фасад) - Керування заводом
        System.out.println("[1] FACADE: Запуск автоматизованої лінії");
        CarAssemblyFacade factoryLine = new CarAssemblyFacade();
        factoryLine.startLine();
        factoryLine.produce();
        System.out.println("----------------------------------------------------");

        // 2. COMPOSITE (Композит) - Дерево запчастин
        System.out.println("[2] COMPOSITE: Структура зібраного автомобіля");
        CarManager manager = new CarManager();
        CarPartComposite myTesla = manager.composeElectricCar();
        myTesla.print();
        System.out.println("\n----------------------------------------------------");

        // 3. ADAPTER (Адаптер) - Підключення старого обладнання
        System.out.println("[3] ADAPTER: Тестування раритетного двигуна");
        structural.adapter.Driver systemTester = new structural.adapter.Driver(new EngineAdapter());
        systemTester.startJourney();
        System.out.println("----------------------------------------------------");

        // 4. BRIDGE (Міст) - Керування та режими
        System.out.println("[4] BRIDGE: Налаштування системи керування");
        VehicleControl sportsControl = new SteeringWheel(new SportMode());
        sportsControl.engage();
        sportsControl.move();
        System.out.println("----------------------------------------------------");

        // 5. DECORATOR (Декоратор) - Тюнінг та опції
        System.out.println("[5] DECORATOR: Додавання преміум-пакетів");
        structural.decorator.Car basicCar = new BasicCar();
        structural.decorator.Car sportArmoredCar = new ArmoredCar(new SportCar(basicCar));
        sportArmoredCar.assemble();
        System.out.println("Опис: " + sportArmoredCar.getDescription());
        System.out.println("Фінальна ціна: $" + sportArmoredCar.getPrice());
        System.out.println("----------------------------------------------------");

        // 6. FLYWEIGHT (Легковаговик) - Оптимізація складу коліс
        System.out.println("[6] FLYWEIGHT: Масове встановлення коліс");
        WheelFactory wheelFactory = new WheelFactory();
        Wheel summer1 = wheelFactory.createWheel(WheelType.SUMMER);
        Wheel summer2 = wheelFactory.createWheel(WheelType.SUMMER);
        Wheel winter1 = wheelFactory.createWheel(WheelType.WINTER);

        CarShowroom showroom = new CarShowroom(List.of(summer1, summer2), List.of(winter1));
        showroom.displayCars(); // Ти побачиш однакові ID об'єктів у консолі
        System.out.println("----------------------------------------------------");

        // 7. PROXY (Замісник) - Система безпеки та доступу
        System.out.println("[7] PROXY: Перевірка прав доступу до двигуна");
        structural.proxy.EngineControl safetySystem = new EngineProxy(new RealEngineControl());

        structural.proxy.Driver intruder = new structural.proxy.Driver("Зломщик", false);
        structural.proxy.Driver owner = new structural.proxy.Driver("Власник", true);

        safetySystem.startEngine(intruder);
        safetySystem.startEngine(owner);

    }
}