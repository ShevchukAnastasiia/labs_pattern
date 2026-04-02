package structural.proxy;

public class EngineProxy implements EngineControl {

    private final EngineControl realEngineControl;

    public EngineProxy(EngineControl realEngineControl) {
        this.realEngineControl = realEngineControl;
    }

    @Override
    public void startEngine(Driver driver) {
        // Перевірка умови доступу
        if (driver.hasKey()) {
            realEngineControl.startEngine(driver);
        } else {
            System.out.println("ВІДМОВА: У водія " + driver + " немає ключа доступу!");
        }
    }
}