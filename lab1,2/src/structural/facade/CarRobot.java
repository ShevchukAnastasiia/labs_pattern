package structural.facade;

import java.util.Arrays;

public abstract class CarRobot {

    public void initialize() {
        System.out.println(name() + ": завантаження ПЗ та самодіагностика...");
    }

    public void calibrate() {
        System.out.println(name() + ": калібрування сенсорів завершено.");
    }

    public void stop() {
        System.out.println(name() + ": зупинка маніпуляторів.");
    }

    public void shutdown() {
        System.out.println(name() + ": перехід у режим енергозбереження.");
    }

    // Логіка обробки команд через Switch (як у викладача)
    private void action(Action action) {
        switch (action) {
            case INITIALIZE -> initialize();
            case CALIBRATE -> calibrate();
            case START_WORK -> performTask();
            case STOP -> stop();
            case SHUTDOWN -> shutdown();
            default -> System.out.println("Команда не розпізнана");
        }
    }

    // Прийом масиву команд (Varargs)
    public void action(Action... actions) {
        Arrays.stream(actions).forEach(this::action);
    }

    public abstract void performTask();

    public enum Action {
       INITIALIZE, CALIBRATE, START_WORK, STOP, SHUTDOWN
    }

    public abstract String name();
}