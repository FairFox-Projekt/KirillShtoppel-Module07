import java.util.*;
interface IMediator {
    void sendMessage(String message, Colleague colleague);
}

abstract class Colleague {
    protected IMediator mediator;
    public Colleague(IMediator mediator) {
        this.mediator = mediator;
    }
    public abstract void receiveMessage(String message);
}

class ChatMediator implements IMediator {
    private List<Colleague> colleagues;
    public ChatMediator() {
        colleagues = new ArrayList<>();
    }
    public void registerColleague(Colleague colleague) {
        colleagues.add(colleague);
    }
    public void sendMessage(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            if (colleague != sender) {
                colleague.receiveMessage(message);
            }
        }
    }
}

class User extends Colleague {
    private String name;
    public User(IMediator mediator, String name) {
        super(mediator);
        this.name = name;
    }
    public void send(String message) {
        System.out.println(name + " sends message: " + message);
        mediator.sendMessage(message, this);
    }
    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }
}