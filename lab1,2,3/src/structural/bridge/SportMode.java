package structural.bridge;

public class SportMode implements DriveMode {
    @Override
    public void onActivate() { System.out.println("Спортивний режим: Підвіска затиснута, оберти піднято."); }
    @Override
    public void onExecute() { System.out.println("Спортивний режим: Максимальна потужність та швидке перемикання!"); }
    @Override
    public void onDeactivate() { System.out.println("Спортивний режим: Повернення до стандартних налаштувань."); }
}