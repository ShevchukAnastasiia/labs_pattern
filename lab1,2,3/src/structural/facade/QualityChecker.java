package structural.facade;

public class QualityChecker extends CarRobot{
    @Override public void performTask() { System.out.println(name() + ": перевірка зазорів та якості збірки."); }
    @Override public String name() { return "Система контролю якості"; }
}

