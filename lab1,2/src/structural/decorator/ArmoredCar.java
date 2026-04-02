package structural.decorator;

public class ArmoredCar implements Car {

    private final Car decoratedCar;

    public ArmoredCar (Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    @Override
    public void assemble() {
        decoratedCar.assemble();
        System.out.println("Встановлення броньованих панелей та куленепробивного скла.");
    }

    @Override
    public double getPrice() {
        return decoratedCar.getPrice() + 15000.0;
    }

    @Override
    public String getDescription() {
        return decoratedCar.getDescription() + ", Броньований захист";
    }
}