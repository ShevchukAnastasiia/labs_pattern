package behavioral.templatemethod;

public abstract class CarMaintenanceProcess {

    // Абстрактні кроки, які реалізують підкласи
    protected abstract String identifyIssues();
    protected abstract void performRepair(String issue);
    protected abstract void runDiagnostics();

    // Це і є Template Method. Він фіксує порядок дій.
    public final void processVehicle() {
        var issue = identifyIssues();
        System.out.println("[Сервіс] Виявлено проблему: " + issue);

        performRepair(issue);
        runDiagnostics();

        System.out.println("[Сервіс] Автомобіль готовий до видачі клієнту!\n");
    }
}