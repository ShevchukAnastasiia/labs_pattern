package behavioral.visitor;

public interface PartVisitor {
    void visit(Engine engine);
    void visit(Gearbox gearbox);
    void visit(BodyWork bodyWork);
}