package structural.facade;

import java.util.List;

public class CarAssemblyFacade {
    private final List<CarRobot> robots;

    public CarAssemblyFacade() {
        // Ініціалізуємо список наших роботів
        robots = List.of(
                new BodyAssembler(),
                new PaintRobot(),
                new QualityChecker()
        );
    }

    // Метод для запуску всієї лінії
    public void startLine() {
        makeActions(robots, CarRobot.Action.INITIALIZE, CarRobot.Action.CALIBRATE);
    }

    // Основний процес виробництва
    public void produce() {
        makeActions(robots, CarRobot.Action.START_WORK);
    }

    // Повна зупинка заводу
    public void stopLine() {
        makeActions(robots, CarRobot.Action.STOP, CarRobot.Action.SHUTDOWN);
    }

    // Внутрішній допоміжний метод (як у викладача)
    private static void makeActions(List<CarRobot> robots, CarRobot.Action... actions) {
        robots.forEach(robot -> robot.action(actions));
    }
}