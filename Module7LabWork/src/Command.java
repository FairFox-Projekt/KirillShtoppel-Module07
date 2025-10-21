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
class Television {
    public void on() {
        System.out.println("TV is on.");
    }
    public void off() {
        System.out.println("TV is off.");
    }
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

class RemoteControl {
    private ICommand onCommand;
    private ICommand offCommand;
    public void setCommands(ICommand onCommand, ICommand offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }
    public void pressOnButton() {
        onCommand.execute();
    }
    public void pressOffButton() {
        offCommand.execute();
    }
    public void pressUndoButton() {
        onCommand.undo();
    }
}
