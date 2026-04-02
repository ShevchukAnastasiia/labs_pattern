package structural.facade;

public class BodyAssembler extends CarRobot {
    @Override public void performTask() { System.out.println(name() + ": зварювання елементів кузова."); }
    @Override public String name() { return "Робот-зварювальник"; }
}
