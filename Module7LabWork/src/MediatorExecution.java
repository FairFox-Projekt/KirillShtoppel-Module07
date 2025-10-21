public class MediatorExecution {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediator();
        User user1 = new User(chatMediator, "Alice");
        User user2 = new User(chatMediator, "Bob");
        User user3 = new User(chatMediator, "Charlie");

        chatMediator.registerColleague(user1);
        chatMediator.registerColleague(user2);
        chatMediator.registerColleague(user3);

        user1.send("Hello everyone!");
        user2.send("Hi!");
        user3.send("Hey.");
    }
}