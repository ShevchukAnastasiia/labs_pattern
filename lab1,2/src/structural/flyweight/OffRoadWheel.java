package structural.flyweight;

public class OffRoadWheel implements Wheel {
    @Override
    public void install() {
        // Тут identityHashCode буде працювати ідеально
        System.out.println("Встановлено позашляхову гуму. (ID: " + System.identityHashCode(this) + ")");
    }
}