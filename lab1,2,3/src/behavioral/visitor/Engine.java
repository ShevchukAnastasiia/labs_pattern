package behavioral.visitor;

public class Engine extends CarPart {
    public Engine(CarPart... children) { super(children); }

    @Override
    public void accept(PartVisitor visitor) {
        visitor.visit(this); // Спочатку відвідуємо себе
        super.accept(visitor); // Потім дітей
    }

    @Override
    public String toString() { return "двигун"; }
}