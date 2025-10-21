public class CommandExecution {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Television tv = new Television();

        ICommand lightOn = new LightOnCommand(livingRoomLight);
        ICommand lightOff = new LightOffCommand(livingRoomLight);
        ICommand tvOn = new TelevisionOnCommand(tv);
        ICommand tvOff = new TelevisionOffCommand(tv);
        RemoteControl remote = new RemoteControl();

        System.out.println("Light control:");
        remote.setCommands(lightOn, lightOff);
        remote.pressOnButton();
        remote.pressOffButton();
        remote.pressUndoButton();

        System.out.println("TV control:");
        remote.setCommands(tvOn, tvOff);
        remote.pressOnButton();
        remote.pressOffButton();
    }
}