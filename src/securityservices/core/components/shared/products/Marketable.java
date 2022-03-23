package securityservices.core.components.shared.products;

public interface Marketable {
    public String getCode();
    public String getName();
    public double getPrice();
    public double getTaxes();
    public String getDetails();
}