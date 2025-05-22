package notification;

import model.User;

import java.util.Date;

public class Notification {
    private String message;
    private Date timestamp;
    private NotificationChannel channel;

    public Notification(String message, NotificationChannel channel) {
        this.message = message;
        this.channel = channel;
        this.timestamp = new Date();
    }

    public void deliverTo(User user) {
        channel.send(message, user);
    }
}