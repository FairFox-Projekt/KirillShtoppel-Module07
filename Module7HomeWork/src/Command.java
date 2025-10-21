import java.util.*;

interface ICommand {
    void execute();
    void undo();
}

class Light {
    public void on() { System.out.println("Light is on."); }
    public void off() { System.out.println("Light is off."); }
}

class Door {
    public void open() { System.out.println("Door is open."); }
    public void close() { System.out.println("Door is closed."); }
}

class Thermostat {
    public void increase() {
        System.out.println("Temperature increased.");
    }
    public void decrease() {
        System.out.println("Temperature decreased.");
    }
}

class TV {
    public void on() { System.out.println("TV is on."); }
    public void off() { System.out.println("TV is off."); }
}

class LightOnCommand implements ICommand {
    private Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.on();
    }
    public void undo() {
        light.off();
    }
}

class LightOffCommand implements ICommand {
    private Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.off();
    }
    public void undo() {
        light.on();
    }
}

class DoorOpenCommand implements ICommand {
    private Door door;
    public DoorOpenCommand(Door door) {
        this.door = door;
    }
    public void execute() {
        door.open();
    }
    public void undo() {
        door.close();
    }
}

class DoorCloseCommand implements ICommand {
    private Door door;
    public DoorCloseCommand(Door door) {
        this.door = door;
    }
    public void execute() {
        door.close();
    }
    public void undo() {
        door.open();
    }
}

class IncreaseTempCommand implements ICommand {
    private Thermostat thermostat;
    public IncreaseTempCommand(Thermostat thermostat) {
        this.thermostat = thermostat;
    }
    public void execute() {
        thermostat.increase();
    }
    public void undo() {
        thermostat.decrease();
    }
}

class DecreaseTempCommand implements ICommand {
    private final Thermostat thermostat;
    public DecreaseTempCommand(Thermostat thermostat) {
        this.thermostat = thermostat;
    }
    public void execute() {
        thermostat.decrease();
    }
    public void undo() {
        thermostat.increase();
    }
}

class TVOnCommand implements ICommand {
    private final TV tv;
    public TVOnCommand(TV tv) {
        this.tv = tv;
    }
    public void execute() {
        tv.on();
    }
    public void undo() {
        tv.off();
    }
}

class TVOffCommand implements ICommand {
    private final TV tv;
    public TVOffCommand(TV tv) {
        this.tv = tv;
    }
    public void execute() {
        tv.off();
    }
    public void undo() {
        tv.on();
    }
}

class RemoteControl {
    private final Stack<ICommand> history = new Stack<>();
    public void executeCommand(ICommand command) {
        command.execute();
        history.push(command);
    }
    public void undoLastCommand() {
        if (!history.isEmpty()) {
            ICommand command = history.pop();
            command.undo();
        } else {
            System.out.println("Nothing there.");
        }
    }
}