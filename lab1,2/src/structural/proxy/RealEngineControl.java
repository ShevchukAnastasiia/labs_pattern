package structural.proxy;

public class RealEngineControl implements EngineControl {
    @Override
    public void startEngine(Driver driver) {
        System.out.println("Двигун успішно запущено для водія: " + driver);
    }
}