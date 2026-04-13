package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CarPartComposite {

    private final List<CarPartComposite> children = new ArrayList<>();

    public void add(CarPartComposite part) {
        children.add(part);
    }

    protected void printBefore() { }

    protected void printAfter() { }

    public void print() {
        printBefore();
        children.forEach(CarPartComposite::print);
        printAfter();
    }
}