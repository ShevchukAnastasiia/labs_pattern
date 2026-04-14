package behavioral.visitor;

public class Gearbox extends CarPart {
    public Gearbox(CarPart... children) { super(children); }

    @Override
    public void accept(PartVisitor visitor) {
        visitor.visit(this);
        super.accept(visitor);
    }

    @Override
    public String toString() { return "коробка передач"; }
}