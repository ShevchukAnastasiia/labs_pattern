package structural.flyweight;

public class SummerWheel implements Wheel {
    @Override
    public void install() {
        System.out.println("Встановлено літню гуму. (ID об'єкта в пам'яті: " + System.identityHashCode(this) + ")");
    }
}