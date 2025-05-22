package notification;

import model.User;

public interface NotificationChannel {
    void send(String message, User user);
}