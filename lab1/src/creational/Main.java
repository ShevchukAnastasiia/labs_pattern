import creational.prototype.CarModel;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Тест Prototype (за прикладом викладача) ---");

        // Створюємо оригінал
        CarModel original = new CarModel("Audi A6", "2.0 TDI");
        System.out.println("Оригінал: " + original);

        // Клонуємо його
        CarModel clone = (CarModel) original.doClone();
        System.out.println("Клон:     " + clone);

        // Перевіряємо рівність
        System.out.println("Чи вони однакові за даними? " + original.equals(clone));
        System.out.println("Чи це один і той самий об'єкт у пам'яті? " + (original == clone));
    }
}