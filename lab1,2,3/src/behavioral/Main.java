package behavioral;

import behavioral.chainofresponsibility.*;
import behavioral.command.*;
import behavioral.iterator.*;
import behavioral.mediator.*;
import behavioral.mediator.systems.*;
import behavioral.memento.*;
import behavioral.observer.*;
import behavioral.state.*;
import behavioral.strategy.*;
import behavioral.templatemethod.*;
import behavioral.visitor.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("   LAB #3: ПОВЕДІНКОВІ ПАТЕРНИ АВТОХОЛДИНГУ");

        // 1. OBSERVER - Стежимо за статусом замовлення
        System.out.println("[1] OBSERVER: Відстеження замовлення");
        CarOrder order = new CarOrder();
        order.addObserver(new Customer("Анастасія"));
        order.addObserver(new Dealer());
        order.nextStep(); // Перехід до виробництва
        System.out.println("----------------------------------------------------");

        // 2. STRATEGY - Рахуємо вартість доставки
        System.out.println("[2] STRATEGY: Розрахунок вартості");
        TaxiOrder delivery = new TaxiOrder(new PremiumStrategy());
        delivery.printFinalPrice(50);
        System.out.println("----------------------------------------------------");

        // 3. ITERATOR - Переглядаємо доступні авто в салоні
        System.out.println("[3] ITERATOR: Пошук електрокарів у салоні");
        CarShowroom showroom = new CarShowroom(List.of(
                new Car(CarType.ELECTRIC, "Tesla Model S"),
                new Car(CarType.SEDAN, "BMW 5"),
                new Car(CarType.ELECTRIC, "Audi e-tron")
        ));
        var electricIterator = showroom.iterator(CarType.ELECTRIC);
        while (electricIterator.hasNext()) {
            System.out.println("Знайдено: " + electricIterator.next());
        }
        System.out.println("----------------------------------------------------");

        // 4. COMMAND - Дистанційне керування функціями
        System.out.println("[4] COMMAND: Дистанційне керування");
        Headlights lights = new Headlights();
        RemoteControlInvoker remote = new RemoteControlInvoker(new HeadlightsCommand(lights));
        remote.pressButton();
        System.out.println("----------------------------------------------------");

        // 5. MEMENTO - Зберігаємо налаштування крісла водія
        System.out.println("[5] MEMENTO: Пам'ять налаштувань");
        CarSettings userSettings = new CarSettings(ProfileType.COMFORT, 45, 12);
        SettingsMemento savedSettings = userSettings.getMemento(); // Зберегли
        userSettings.changeSettings(ProfileType.SPORT, 10, -5); // Змінили
        userSettings.setMemento(savedSettings); // Відновили
        System.out.println("----------------------------------------------------");

        // 6. STATE - Керування режимами автопілота
        System.out.println("[6] STATE: Робота автопілота");
        AutonomousCar tesla = new AutonomousCar();
        tesla.showDashboard();
        tesla.toggleMode(); // Перейшли в режим руху
        tesla.showDashboard();
        System.out.println("----------------------------------------------------");

        // 7. MEDIATOR - Координація систем під час руху
        System.out.println("[7] MEDIATOR: Бортовий комп'ютер у дії");
        CentralComputer computer = new CentralComputer();
        NavigationSystem navi = new NavigationSystem();
        BrakeSystem brakes = new BrakeSystem();

        computer.registerComponent(navi);
        computer.registerComponent(brakes);
        computer.registerComponent(new LightSystem());

        navi.triggerEvent(VehicleAction.OBSTACLE_DETECTED);
        System.out.println("----------------------------------------------------");

        // 8. TEMPLATE METHOD - Процес техобслуговування
        System.out.println("[8] TEMPLATE METHOD: Сервісне обслуговування");
        ServiceStation station = new ServiceStation(new ElectricCarMaintenance());
        station.maintain();
        System.out.println("----------------------------------------------------");

        // 9. VISITOR - Технічний аудит запчастин
        System.out.println("[9] VISITOR: Глибока інспекція");
        CarPart carStructure = new Engine(new Gearbox(), new BodyWork());
        carStructure.accept(new TechnicalInspector());
        System.out.println("----------------------------------------------------");

        // 10. CHAIN OF RESPONSIBILITY - Служба підтримки
        System.out.println("[10] CHAIN OF RESPONSIBILITY: Звернення клієнта");
        SupportService support = new SupportService(List.of(
                new Consultant(), new Technician(), new Manager()
        ));
        support.processRequest(new ServiceRequest(ServiceType.TECHNICAL_REPAIR, "Двигун видає дивний звук"));

    }
}