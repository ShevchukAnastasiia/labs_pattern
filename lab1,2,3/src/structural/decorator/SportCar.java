package structural.decorator;

public class SportCar implements Car {

    private final Car decoratedCar;

    public SportCar (Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    @Override
    public void assemble() {
        decoratedCar.assemble(); // Спочатку збираємо базу
        System.out.println("Додавання спортивної підвіски та турбонаддуву!");
    }

    @Override
    public double getPrice() {
        // Додаємо вартість спортивного пакету до поточної ціни
        return decoratedCar.getPrice() + 5000.0;
    }

    @Override
    public String getDescription() {
        return decoratedCar.getDescription() + ", Спортивний пакет";
    }
}