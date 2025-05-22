import model.*;
import controller.*;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "user@example.com");
        Subscription sub = new Subscription("https://example.com", "daily", "email");

        SystemController controller = new SystemController();
        controller.registerSubscription(user, sub);

        System.out.println("Checking for updates...");
        controller.checkForUpdates();
    }
}
