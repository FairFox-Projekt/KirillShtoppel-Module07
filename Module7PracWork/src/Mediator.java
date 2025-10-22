import java.util.*;
interface IMediator {
    void sendMessage(String message, IUser sender, String channel);
    void addUser(IUser user, String channel);
    void removeUser(IUser user, String channel);
}
interface IUser {
    void receiveMessage(String message);
    void sendMessage(String message, String channel);
    String getName();
}

class User implements IUser {
    private String name;
    private IMediator mediator;
    public User(String name, IMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
    public String getName() {
        return name;
    }
    public void sendMessage(String message, String channel) {
        System.out.println("[" + channel + "] " + name + " sends: " + message);
        mediator.sendMessage(message, this, channel);
    }
    public void receiveMessage(String message) {
        System.out.println(message);
    }
}
class ChannelMediator {
    private String name;
    private List<IUser> users = new ArrayList<>();
    public ChannelMediator(String name) {
        this.name = name;
    }
    public void addUser(IUser user) {
        users.add(user);
        broadcast("[" + name + "] " + user.getName() + " joined the channel", null);
    }
    public void removeUser(IUser user) {
        broadcast("[" + name + "] " + user.getName() + " left the channel", user);
        users.remove(user);
    }
    public void broadcast(String message, IUser sender) {
        for (IUser user : users)
            if (user != sender)
            {
                user.receiveMessage(message);
            }
    }
}

class ChatMediator implements IMediator {
    private Map<String, ChannelMediator> channels = new HashMap<>();
    public void addUser(IUser user, String channel) {
        channels.putIfAbsent(channel, new ChannelMediator(channel));
        channels.get(channel).addUser(user);
    }
    public void removeUser(IUser user, String channel) {
        if (channels.containsKey(channel))
        {
            channels.get(channel).removeUser(user);
        }
    }
    public void sendMessage(String message, IUser sender, String channel) {
        if (channels.containsKey(channel))
        {
            channels.get(channel).broadcast("[" + channel + "] " + sender.getName() + ": " + message, sender);
        }
    }
}
