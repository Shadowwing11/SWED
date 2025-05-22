import java.util.Date;

public class Subscription {
    private String url;
    private String monitorFrequency;
    private String contactChannel;
    private Date lastChecked;

    public Subscription(String url, String monitorFrequency, String contactChannel) {
        this.url = url;
        this.monitorFrequency = monitorFrequency;
        this.contactChannel = contactChannel;
        this.lastChecked = new Date();
    }

    public String getUrl() {
        return url;
    }

    public String getMonitorFrequency() {
        return monitorFrequency;
    }

    public String getContactChannel() {
        return contactChannel;
    }

    public Date getLastChecked() {
        return lastChecked;
    }
}
