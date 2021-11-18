package securityservices.stakeholders;

public class Provider extends Person implements StakeHolder{
    private Company companyData = new Company();
    private int delayPayment;
    private double discount;

    public Provider() {
    }

    public Provider(String name, String ident, String email, String phone, String address, String birthday,
                int delayPayment, double discount, String socialReason, String type) {
        super(name, ident, email, phone, address, birthday);
        this.delayPayment = delayPayment;
        this.discount = discount;
        this.companyData.setSocialReason(socialReason);
        this.companyData.setType(type);
    }

    public int getDelayPayment() {
        return delayPayment;
    }

    public void setDelayPayment(int delayPayment) {
        this.delayPayment = delayPayment;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public String getSocialReason() {
        return this.companyData.getSocialReason();
    }

    public void setSocialReason(String socialReason) {
        this.companyData.setSocialReason( socialReason);
    }

    public String getType() {
        return this.companyData.getType();
    }

    public void setType(String type) {
        this.companyData.setType(type);
    }
    
    @Override
    public String getCode() {
       return this.getIdent();
    }

    @Override
    public String getDetails() {
        return "companyType:" + this.companyData.type + 
               ";delayPayment:" + this.delayPayment + 
                ";discount:" + this.discount;
    }

}
