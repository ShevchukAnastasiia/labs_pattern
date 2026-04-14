package behavioral.templatemethod;

public class ElectricCarMaintenance extends CarMaintenanceProcess {
    @Override
    protected String identifyIssues() { return "деградація батареї"; }

    @Override
    protected void performRepair(String issue) {
        System.out.println("Виконується балансування комірок акумулятора для усунення: " + issue);
    }

    @Override
    protected void runDiagnostics() {
        System.out.println("Оновлення програмного забезпечення контролера живлення.");
    }
}