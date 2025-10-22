import java.util.*;

interface ICommand {
    void execute();
    void undo();
}

class Light {
    public void on() {
        System.out.println("Light is on.");
    }
    public void off() {
        System.out.println("Light is off.");
    }
}
class AirConditioner {
    public void on() {
        System.out.println("Air conditioner is on.");
    }
    public void off() {
        System.out.println("Air conditioner is off.");
    }
}
class Television {
    public void on() {
        System.out.println("Television is on.");
    }
    public void off() {
        System.out.println("Television is off.");
    }
}

class LightOnCommand implements ICommand {
    private Light light;
    public LightOnCommand(Light light) { this.light = light; }
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

class AirConditionerOnCommand implements ICommand {
    private AirConditioner ac;
    public AirConditionerOnCommand(AirConditioner ac) {
        this.ac = ac;
    }
    public void execute() {
        ac.on();
    }
    public void undo() {
        ac.off();
    }
}

class AirConditionerOffCommand implements ICommand {
    private AirConditioner ac;
    public AirConditionerOffCommand(AirConditioner ac) {
        this.ac = ac;
    }
    public void execute() {
        ac.off();
    }
    public void undo() {
        ac.on();
    }
}

class TelevisionOnCommand implements ICommand {
    private Television tv;
    public TelevisionOnCommand(Television tv) {
        this.tv = tv;
    }
    public void execute() {
        tv.on();
    }
    public void undo() {
        tv.off();
    }
}
class TelevisionOffCommand implements ICommand {
    private Television tv;
    public TelevisionOffCommand(Television tv) {
        this.tv = tv;
    }
    public void execute() {
        tv.off();
    }
    public void undo() {
        tv.on();
    }
}

class MacroCommand implements ICommand {
    private List<ICommand> commands;
    public MacroCommand(List<ICommand> commands) {
        this.commands = commands;
    }
    public void execute() {
        for (ICommand c : commands) {
            c.execute();
        }
    }
    public void undo() { for (ICommand c : commands) {
        c.undo();
    }
    }
}

class RemoteControl {
    private Map<String, ICommand> commandMap = new HashMap<>();
    private Stack<ICommand> history = new Stack<>();
    private Stack<ICommand> undone = new Stack<>();
    public void setCommand(String button, ICommand command) {
        commandMap.put(button, command);
    }
    public void pressButton(String button) {
        ICommand command = commandMap.get(button);
        if (command != null) {
            command.execute();
            history.push(command);
            undone.clear();
        }
    }
    public void undoLast() {
        if (!history.isEmpty()) {
            ICommand command = history.pop();
            command.undo();
            undone.push(command);
        }
    }
    public void redoLast() {
        if (!undone.isEmpty()) {
            ICommand command = undone.pop();
            command.execute();
            history.push(command);
        }
    }
}