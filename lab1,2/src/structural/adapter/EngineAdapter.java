package structural.adapter;

public class EngineAdapter implements Drivable {
    private final OldEngine oldEngine = new OldEngine();

    @Override
    public void drive() {
        oldEngine.ignite();
    }
}
