package securityservices.products;

public abstract class Product implements Marketable {

    protected String code, name, type, maker, description;
    protected double price, taxes;
    protected Boolean available;

    public Product() {
        this.available = true;
    }

    public Product(String code, String name, String type, String maker, String description,
            double price, double taxes) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.maker = maker;
        this.description = description;
        this.price = price;
        this.available = true;
        this.taxes = taxes;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean isAvailable() {
        return available;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getTaxes() {
        return this.taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }
    
    
}
