package creational;

import creational.builder.Transmission;
import creational.factorymethod.*;
import creational.abstractfactory.CarAssembly;
import creational.abstractfactory.CarPartsFactory;
import creational.builder.BodyType;
import creational.builder.EngineType;
import creational.builder.CarColor;
import creational.prototype.CarModel;

public class Main {
    public static void main(String[] args) {

        System.out.println("   WELCOME TO THE AUTOMOTIVE CONVEYOR SYSTEM");

        // КРОК 1: SINGLETON (Одинак) - Запуск системи
        // Спочатку ми вмикаємо головний мозок заводу. Він один на всю будівлю.
        System.out.println("\n[КРОК 1] Ініціалізація головного вузла (Singleton)");
        creational.singleton.CarFactory factoryBrain = creational.singleton.CarFactory.getInstance();
        System.out.println("Система: " + factoryBrain.assemble());

        // КРОК 2: FACTORY METHOD (Фабричний метод) - Вибір виробника
        // Вирішуємо, хто сьогодні працює: преміальний бренд чи бюджетний (як Ельфи/Орки).
        System.out.println("\n[КРОК 2] Визначення сегменту виробництва (Factory Method)");
        VehicleManufacturer brandManager = new PremiumManufacturer(); // Обираємо преміум-цех
        Vehicle baseVehicle = brandManager.manufactureVehicle(VehicleType.SUV);
        System.out.println("Виробник: " + brandManager + " підготував концепт: " + baseVehicle);

        // КРОК 3: SIMPLE FACTORY (Проста фабрика) - Вибір кузова
        // Диспетчер каже, на якій платформі будемо збирати машину.
        System.out.println("\n[КРОК 3] Підбір базової платформи (Simple Factory)");
        creational.factory.Car carBase = creational.factory.CarFactory.createCar(creational.factory.CarType.SUV);
        System.out.println("Платформа: " + carBase.getDescription());

        // КРОК 4: ABSTRACT FACTORY (Абстрактна фабрика) - Набір запчастин
        // Замовляємо комплект деталей, які 100% підійдуть до обраного типу (електричний).
        System.out.println("\n[КРОК 4] Доставка сумісних компонентів (Abstract Factory)");
        CarPartsFactory techStore = CarAssembly.FactoryMaker.makeFactory(creational.abstractfactory.CarType.ELECTRIC);
        CarAssembly components = new CarAssembly(
                techStore.createEngine(),
                techStore.createBody(),
                techStore.createWheels()
        );
        System.out.println("Комплект: " + components.engine().description() + " + " + components.body().description());

        // КРОК 5: BUILDER (Будівельник) - Фінальна збірка
        // Тепер накручуємо на нашу платформу колір, люк та інші хотілки клієнта.
        System.out.println("\n[КРОК 5] Персоналізована збірка клієнтського авто (Builder)");
        creational.builder.Car finalCar = new creational.builder.Car.Builder(BodyType.SUV, "Audi Q8 e-tron")
                .withEngine(EngineType.ELECTRIC)
                .withTransmission(Transmission.AUTOMATIC)
                .withColor(CarColor.BLACK)
                .withSunroof(true)
                .build();
        System.out.println("РЕЗУЛЬТАТ: Машина виїхала з цеху! -> " + finalCar);

        // КРОК 6: PROTOTYPE (Прототип) - Масове виробництво
        // Машина крута, тому ми просто копіюємо її для виставки в іншому місті.
        System.out.println("\n[КРОК 6] Створення виставкових екземплярів (Prototype)");
        CarModel masterModel = new CarModel("Audi Exhibition Edition", "Twin Electric Motors");
        CarModel copyModel = (CarModel) masterModel.doClone();
        System.out.println("Клон для шоуруму: " + copyModel);
    }
}