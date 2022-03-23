package securityservices.core.components.shared.stakeholders;

public class Company {
    protected String socialReason, type;

    public Company() {
    }

    public Company(String socialReason, String type) {
        this.socialReason = socialReason;
        this.type = type;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
