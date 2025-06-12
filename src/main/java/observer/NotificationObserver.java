package observer;

import model.User;
import notification.Notification;
import notification.NotificationChannel;

public class NotificationObserver implements Observer {
    private final User user;
    private final NotificationChannel channel;

    public NotificationObserver(User user, NotificationChannel channel) {
        this.user = user;
        this.channel = channel;
    }

    @Override
    public void update(String content) {
        Notification notification = new Notification("Website updated: " + content, channel);
        notification.deliverTo(user);
    }
}