ackage notification;

import model.User;

public class EmailChannel implements NotificationChannel {
    @Override
    public void send(String message, User user) {
        System.out.println("Email to " + user.getContactInfo() + ": " + message);
    }
}