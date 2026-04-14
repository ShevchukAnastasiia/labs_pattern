package behavioral.visitor;

public class TechnicalInspector implements PartVisitor {
    @Override
    public void visit(Engine engine) { System.out.println("Механік: Перевірка рівня масла та компресії в " + engine); }

    @Override
    public void visit(Gearbox gearbox) { System.out.println("Механік: Тестування перемикання швидкостей у " + gearbox); }

    @Override
    public void visit(BodyWork bodyWork) { System.out.println("======="); }
}