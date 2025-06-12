package observer;

import strategy.ComparisonStrategy;

public class WebsiteMonitor extends Subject {
    private String content = "";
    private final ComparisonStrategy strategy;

    public WebsiteMonitor(ComparisonStrategy strategy) {
        this.strategy = strategy;
    }

    public void setContent(String newContent) {
        if (strategy.isUpdated(this.content, newContent)) {
            this.content = newContent;
            notifyObservers(content);
        }
    }

    public String getContent() {
        return content;
    }
}