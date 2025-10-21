public class CommandExecution {
    public static void main(String[] args) {
        Light light = new Light();
        Door door = new Door();
        Thermostat thermostat = new Thermostat();
        TV tv = new TV();

        ICommand lightOn = new LightOnCommand(light);
        ICommand doorOpen = new DoorOpenCommand(door);
        ICommand increaseTemp = new IncreaseTempCommand(thermostat);
        ICommand tvOn = new TVOnCommand(tv);

        RemoteControl remote = new RemoteControl();

        remote.executeCommand(lightOn);
        remote.executeCommand(doorOpen);
        remote.executeCommand(increaseTemp);
        remote.executeCommand(tvOn);

        remote.undoLastCommand();
        remote.undoLastCommand();
        remote.undoLastCommand();
        remote.undoLastCommand();
        remote.undoLastCommand();
    }
}