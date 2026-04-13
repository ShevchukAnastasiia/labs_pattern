//створ лише один раз,можна тільки просити щоб дало той самий екземпрляр.

package creational.singleton;

public class CarFactory {

    // volatile гарантує, що зміни змінної будуть видні всім потокам
    private volatile static CarFactory instance = null;


    private CarFactory() {}
    //getInstance() для отримання екземпляру класу
    public static CarFactory getInstance() {
        // Перша перевірка (без блокування для швидкості)
        if (instance == null) {
            synchronized (CarFactory.class) {
                if (instance == null) {
                    instance = new CarFactory();
                }
            }
        }
        return instance;
    }

    // метод для збірки
    public String assemble() {
        return "Машина зібрана на головному заводі.";
    }
}