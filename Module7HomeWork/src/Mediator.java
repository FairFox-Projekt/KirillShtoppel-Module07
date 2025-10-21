interface IMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

class ChatRoom implements IMediator {
    private java.util.List<User> users = new java.util.ArrayList<>();
    public void addUser(User user) {
        users.add(user);
    }
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receive(message);
            }
        }
    }
}
abstract class User {
    protected IMediator mediator;
    protected String name;
    public User(IMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }
    public abstract void send(String message);
    public abstract void receive(String message);
}

class ChatUser extends User {
    public ChatUser(IMediator mediator, String name) { super(mediator, name); }
    public void send(String message) {
        mediator.sendMessage(name + ": " + message, this
        );
    }
    public void receive(String message) {
        System.out.println(name + " got message: " + message
        );
    }
}
