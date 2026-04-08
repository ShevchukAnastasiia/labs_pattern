package structural.bridge;

public class EcoMode implements DriveMode {
    @Override
    public void onActivate() { System.out.println("Еко режим: Обмеження потужності для економії пального."); }
    @Override
    public void onExecute() { System.out.println("Еко режим: Плавне прискорення та рекуперація енергії."); }
    @Override
    public void onDeactivate() { System.out.println("Еко режим: Вихід з режиму економії."); }
}