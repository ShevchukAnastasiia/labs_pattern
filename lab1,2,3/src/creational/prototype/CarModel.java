package creational.prototype;

import java.util.Objects;

public class CarModel implements Prototype {

    private final String modelName;
    private final String engine;

    public CarModel(String modelName, String engine) {
        this.modelName = modelName;
        this.engine = engine;
    }

    // Реалізація клонування через конструктор (як у викладача)
    @Override
    public Prototype doClone() {
        return new CarModel(modelName, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(modelName, carModel.modelName) &&
                Objects.equals(engine, carModel.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, engine);
    }

    @Override
    public String toString() {
        return "CarModel{модель='" + modelName + "', двигун='" + engine + "'}";
    }
}
