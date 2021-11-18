package securityservices.products;

public class Software extends Product {
    protected String version, os;

    public Software() {
    }

    public Software(String code, String name, String type, String maker, String description, double price, 
            double taxes, String version, String os, String medium) {
        super(code, name, type, maker, description, price, taxes);
        this.version = version;
        this.os = os;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }


    @Override
    public String getDetails() {
        return "Version:" + this.version + ";OS:" + this.os + 
                ";Especifications:" + this.description;
    }   
}