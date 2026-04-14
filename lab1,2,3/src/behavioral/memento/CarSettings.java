package behavioral.memento;

public class CarSettings {

    private ProfileType profile;
    private int seatDistance;
    private int mirrorAngle;

    public CarSettings(ProfileType profile, int seatDistance, int mirrorAngle) {
        this.profile = profile;
        this.seatDistance = seatDistance;
        this.mirrorAngle = mirrorAngle;
    }

    // Метод, що змінює стан (аналог timePasses)
    public void changeSettings(ProfileType newProfile, int distDelta, int angleDelta) {
        System.out.println("\n--- Зміна налаштувань на " + newProfile + " ---");
        this.profile = newProfile;
        this.seatDistance += distDelta;
        this.mirrorAngle += angleDelta;
    }

    // Створюємо знімок
    public SettingsMemento getMemento() {
        return new SettingsMementoInternal(profile, seatDistance, mirrorAngle);
    }

    // Відновлюємося зі знімка
    public void setMemento(SettingsMemento memento) {
        var state = (SettingsMementoInternal) memento;
        this.profile = state.profile();
        this.seatDistance = state.seatDistance();
        this.mirrorAngle = state.mirrorAngle();
        System.out.println(">>> Стан успішно відновлено: " + this);
    }

    @Override
    public String toString() {
        return String.format("Профіль: %s, Відстань крісла: %d см, Кут дзеркал: %d°",
                profile, seatDistance, mirrorAngle);
    }

    // Внутрішній record для зберігання даних (аналог StarMementoInternal)
    private record SettingsMementoInternal(ProfileType profile, int seatDistance, int mirrorAngle)
            implements SettingsMemento {
    }
}