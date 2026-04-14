package behavioral.visitor;

import java.util.Arrays;

public abstract class CarPart {

    private final CarPart[] children;

    public CarPart(CarPart... children) {
        this.children = children;
    }

    public void accept(PartVisitor visitor) {
        // Рекурсивно пропускаємо візитора по всій структурі
        Arrays.stream(children).forEach(child -> child.accept(visitor));
    }
}