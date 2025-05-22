package notification;

import model.User;

public class SMSChannel implements NotificationChannel {
    @Override
    public void send(String message, User user) {
        System.out.println("SMS to " + user.getContactInfo() + ": " + message);
    }
}
