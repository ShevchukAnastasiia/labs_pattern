package structural.decorator;

public class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.println("Збірка базового автомобіля...");
    }

    @Override
    public double getPrice() {
        return 20000.0; // Базова ціна
    }

    @Override
    public String getDescription() {
        return "Стандартна комплектація";
    }
}