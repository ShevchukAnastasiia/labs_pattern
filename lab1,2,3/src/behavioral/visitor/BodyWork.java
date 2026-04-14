package behavioral.visitor;

public class BodyWork extends CarPart {
    public BodyWork(CarPart... children) { super(children); }

    @Override
    public void accept(PartVisitor visitor) {
        visitor.visit(this);
        super.accept(visitor);
    }

    @Override
    public String toString() { return "кузов"; }
}