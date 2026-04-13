package structural.composite;

public class Part extends CarPartComposite {
    private final String name;

    public Part(String name) {
        this.name = name;
    }

    @Override
    protected void printBefore() {
        System.out.print(" [" + name + "] ");
    }
}