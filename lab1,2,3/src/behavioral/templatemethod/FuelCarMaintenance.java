package behavioral.templatemethod;

public class FuelCarMaintenance extends CarMaintenanceProcess {
    @Override
    protected String identifyIssues() { return "забруднення паливних форсунок"; }

    @Override
    protected void performRepair(String issue) {
        System.out.println("Промивка паливної системи та заміна фільтрів для: " + issue);
    }

    @Override
    protected void runDiagnostics() {
        System.out.println("Аналіз складу вихлопних газів та перевірка компресії.");
    }
}