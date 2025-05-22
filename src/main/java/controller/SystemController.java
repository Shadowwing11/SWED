package controller;

import model.*;
import notification.*;

import java.util.*;

public class SystemController {
    private Map<User, List<Subscription>> userSubscriptions = new HashMap<>();

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

    public void updateSubscription() {
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
                if (Math.random() > 0.5) { // Mock update check
                    NotificationChannel channel = switch (sub.getContactChannel().toLowerCase()) {
                        case "email" -> new EmailChannel();
                        default -> new EmailChannel(); // fallback
                    };
                    Notification notification = new Notification("Update found on " + sub.getUrl(), channel);
                    notifyUser(user, notification);
                }
            }
        }
    }

