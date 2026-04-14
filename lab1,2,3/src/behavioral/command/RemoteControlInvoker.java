package behavioral.command;

public class RemoteControlInvoker {
    private Command command;

    public RemoteControlInvoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        System.out.print("[Додаток] Натиснуто кнопку: ");
        command.execute();
    }
}