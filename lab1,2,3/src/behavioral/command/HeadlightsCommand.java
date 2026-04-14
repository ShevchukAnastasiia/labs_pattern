package behavioral.command;

public class HeadlightsCommand implements Command {
    private final Headlights headlights;

    public HeadlightsCommand(Headlights headlights) {
        this.headlights = headlights;
    }

    @Override
    public void execute() {
        headlights.turnOn();
    }
}