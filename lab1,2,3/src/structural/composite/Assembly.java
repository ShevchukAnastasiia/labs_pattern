package structural.composite;

import java.util.List;

public class Assembly extends CarPartComposite {
    private final String assemblyName;

    public Assembly(String name, List<Part> parts) {
        this.assemblyName = name;
        parts.forEach(this::add);
    }

    @Override
    protected void printBefore() {
        System.out.print("\n Вузол " + assemblyName + ": {");
    }

    @Override
    protected void printAfter() {
        System.out.print("}");
    }
}