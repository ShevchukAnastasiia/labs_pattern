package behavioral.command;

public class AlarmCommand implements Command {
    private final CarAlarm alarm;

    public AlarmCommand(CarAlarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.activate();
    }
}