package structural.flyweight;

public class WinterWheel implements Wheel {
    @Override
    public void install() {
        System.out.println("Встановлено зимову гуму. (ID об'єкта в пам'яті: " + System.identityHashCode(this) + ")");
    }
}