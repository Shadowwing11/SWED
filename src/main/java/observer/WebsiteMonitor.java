package observer;

public class WebsiteMonitor extends Subject {
    private String content = "";

    public void setContent(String newContent) {
        if (!newContent.equals(this.content)) {
            this.content = newContent;
            notifyObservers(content);
        }
    }

    public String getContent() {
        return content;
    }
}
