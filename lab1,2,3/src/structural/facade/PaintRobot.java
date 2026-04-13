package structural.facade;

public class PaintRobot extends CarRobot {
    @Override public void performTask() { System.out.println(name() + ": нанесення лакофарбового покриття."); }
    @Override public String name() { return "Робот-фарбувальник"; }
}
