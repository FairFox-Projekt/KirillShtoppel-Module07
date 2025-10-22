public class MediatorExecution {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();
        IUser user1 = new User("User1", mediator);
        IUser user2 = new User("User2", mediator);
        IUser user3 = new User("User3", mediator);

        mediator.addUser(user1, "general");
        mediator.addUser(user2, "general");
        mediator.addUser(user3, "general2");

        user1.sendMessage("Hello!", "general");
        user2.sendMessage("Hi!", "general");
        user3.sendMessage("What am I even doing here?...", "general2");

        mediator.removeUser(user2, "general");
    }
}