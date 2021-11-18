package securityservices.products;

public class Service extends Product {
    protected String periodicity, conditions;

    public Service() {
    }

    public Service(String code, String name, String type, String maker, String description, double price,
            double taxes, String periodicity, String conditions) {
        super(code, name, type, maker, description, price, taxes);
        this.periodicity = periodicity;
        this.conditions = conditions;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String getDetails() {
        return "Periodicity:" + this.periodicity
                + ";Conditions:" + this.conditions;
    }
}