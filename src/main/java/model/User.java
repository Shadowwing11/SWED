package model;
import java.util.ArrayList;
import java.util.List;
import model.Subscription;

public class User {
    private int userID;
    private String contactInfo;
    private List<Subscription> subList = new ArrayList<>();

    public User(int userID, String contactInfo) {
        this.userID = userID;
        this.contactInfo = contactInfo;
    }

    public void register(Subscription subscription) {
        subList.add(subscription);
    }

    public void modifySubscription(int index, Subscription newSub) {
        if (index >= 0 && index < subList.size()) {
            subList.set(index, newSub);
        }
    }

    public void cancelSubscription(Subscription sub) {
        subList.remove(sub);
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<Subscription> getSubscriptions() {
        return subList;
    }
}
