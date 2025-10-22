import java.util.*;
public class CommandExecution {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        AirConditioner ac = new AirConditioner();
        Television tv = new Television();

        ICommand lightOn = new LightOnCommand(light);
        ICommand lightOff = new LightOffCommand(light);
        ICommand acOn = new AirConditionerOnCommand(ac);
        ICommand acOff = new AirConditionerOffCommand(ac);
        ICommand tvOn = new TelevisionOnCommand(tv);
        ICommand tvOff = new TelevisionOffCommand(tv);

        remote.setCommand("LightOn", lightOn);
        remote.setCommand("LightOff", lightOff);
        remote.setCommand("ACOn", acOn);
        remote.setCommand("ACOff", acOff);
        remote.setCommand("TVOn", tvOn);
        remote.setCommand("TVOff", tvOff);

        List<ICommand> partyCommands = Arrays.asList(lightOn, acOn, tvOn);
        ICommand partyMacro = new MacroCommand(partyCommands);
        remote.setCommand("CommandSet", partyMacro);

        System.out.println("Executing commands:");
        remote.pressButton("LightOn");
        remote.pressButton("ACOn");
        remote.pressButton("TVOn");

        System.out.println("Undo last command:");
        remote.undoLast();

        System.out.println("Redo last command:");
        remote.redoLast();

        System.out.println("Activating Party Mode:");
        remote.pressButton("CommandSet");

        System.out.println("Undo Party Mode:");
        remote.undoLast();
    }
}