package creational.singleton;

public class CarFactory {

    // volatile гарантує, що зміни змінної будуть видні всім потокам
    private volatile static CarFactory instance = null;

    // Приватний конструктор
    private CarFactory() {}

    public static CarFactory getInstance() {
        // Перша перевірка (без блокування для швидкості)
        if (instance == null) {
            // Блокування для безпеки при одночасному зверненні кількох потоків
            synchronized (CarFactory.class) {
                // Друга перевірка (всередині блокування)
                if (instance == null) {
                    instance = new CarFactory();
                }
            }
        }
        return instance;
    }

    // Замість mage() у нас буде метод для збірки
    public String assemble() {
        return "Машина зібрана на головному заводі.";
    }
}