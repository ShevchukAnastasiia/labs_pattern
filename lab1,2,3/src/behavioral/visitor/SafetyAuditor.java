package behavioral.visitor;

public class SafetyAuditor implements PartVisitor {
    @Override
    public void visit(Engine engine) { System.out.println("-------"); }

    @Override
    public void visit(Gearbox gearbox) { System.out.println("-------"); }

    @Override
    public void visit(BodyWork bodyWork) {
        System.out.println("Аудитор: Перевірка цілісності силових структур у " + bodyWork);
    }
}