public class User {
    private String userId;
    private String contactInfo;

    public User(String userId, String contactInfo) {
        this.userId = userId;
        this.contactInfo = contactInfo;
    }

    public String getUserId() { return userId; }
    public String getContactInfo() { return contactInfo; }
}
