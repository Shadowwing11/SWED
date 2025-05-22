public class Notification {
    private String message;
    private long timestamp;
    private NotificationChannel channel;

    public Notification(String message, NotificationChannel channel) {
        this.message = message;
        this.channel = channel;
        this.timestamp = System.currentTimeMillis();
    }

    public void deliverTo(User user) {
        channel.send(message, user);
    }
}
