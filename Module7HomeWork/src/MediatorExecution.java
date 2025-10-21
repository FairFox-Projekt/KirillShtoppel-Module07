public class MediatorExecution {
    public static void main(String[] args) {
        IMediator chat = new ChatRoom();
        User u1 = new ChatUser(chat, "User1");
        User u2 = new ChatUser(chat, "User2");
        User u3 = new ChatUser(chat, "User3");

        chat.addUser(u1);
        chat.addUser(u2);
        chat.addUser(u3);

        u1.send("Hi");
        u2.send("ok?");
    }
}