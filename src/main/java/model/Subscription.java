public class Subscription {
    private String url;
    private String frequency;
    private String channel;
    private long lastChecked;

    public Subscription(String url, String frequency, String channel) {
        this.url = url;
        this.frequency = frequency;
        this.channel = channel;
        this.lastChecked = System.currentTimeMillis();
    }

    public String getUrl() { return url; }
    public String getFrequency() { return frequency; }
    public String getChannel() { return channel; }

    public boolean isUpdated() {
        // Placeholder logic
        return Math.random() > 0.5;
    }
}
