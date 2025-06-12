package controller;

import model.*;
import notification.*;
import observer.Observer;
import observer.NotificationObserver;
import observer.WebsiteMonitor;

import strategy.*;

import java.util.*;

public class SystemController {
    private final Map<User, List<Subscription>> userSubscriptions = new HashMap<>();

    public void registerSubscription(User user, Subscription subscription) {
        user.register(subscription);
        userSubscriptions.computeIfAbsent(user, k -> new ArrayList<>()).add(subscription);
    }

    public void cancelSubscription(User user, Subscription subscription) {
        user.cancelSubscription(subscription);
        List<Subscription> subs = userSubscriptions.get(user);
        if (subs != null) {
            subs.remove(subscription);
        }
    }

    public void updateSubscription(User user, int index, Subscription newSub) {
        List<Subscription> list = userSubscriptions.get(user);
        if (list != null && index >= 0 && index < list.size()) {
            list.set(index, newSub);
            user.modifySubscription(index, newSub);
        }
    }

    public void checkForUpdates() {
        for (Map.Entry<User, List<Subscription>> entry : userSubscriptions.entrySet()) {
            User user = entry.getKey();
            for (Subscription sub : entry.getValue()) {
                try {
                    String newContent = WebChecker.fetchWebsiteContent(sub.getUrl());

                    // Choose comparison strategy — for demo use text comparison
                    ComparisonStrategy strategy = new TextComparisonStrategy();
                    WebsiteMonitor monitor = new WebsiteMonitor(strategy);

                    NotificationChannel channel = switch (sub.getContactChannel().toLowerCase()) {
                        case "email" -> new EmailChannel();
                        case "sms" -> new SMSChannel();
                        default -> new EmailChannel();
                    };

                    Observer observer = new NotificationObserver(user, channel);
                    monitor.attach(observer);
                    monitor.setContent(newContent);

                } catch (Exception e) {
                    System.out.println("Error fetching content for " + sub.getUrl() + ": " + e.getMessage());
                }
            }
        }
    }

    public void notifyUser(User user, Notification notification) {
        notification.deliverTo(user);
    }
}
