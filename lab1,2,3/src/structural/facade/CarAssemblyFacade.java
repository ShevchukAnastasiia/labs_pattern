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

    public void startLine() {
        makeActions(robots, CarRobot.Action.INITIALIZE, CarRobot.Action.CALIBRATE);
    }

    public void produce() {
        makeActions(robots, CarRobot.Action.START_WORK);
    }

    public void stopLine() {
        makeActions(robots, CarRobot.Action.STOP, CarRobot.Action.SHUTDOWN);
    }

    private static void makeActions(List<CarRobot> robots, CarRobot.Action... actions) {
        robots.forEach(robot -> robot.action(actions));
    }
}