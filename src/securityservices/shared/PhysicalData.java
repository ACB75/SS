package securityservices.shared;

public class PhysicalData {

    protected Double high, wide, deep, weight;
    protected Boolean fragile;

    public PhysicalData() {
    }

    public PhysicalData(Double high, Double wide, Double deep, Double weight, Boolean fragile) {
        this.high = high;
        this.wide = wide;
        this.deep = deep;
        this.weight = weight;
        this.fragile = fragile;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getWide() {
        return wide;
    }

    public void setWide(Double wide) {
        this.wide = wide;
    }

    public Double getDeep() {
        return deep;
    }

    public void setDeep(Double deep) {
        this.deep = deep;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean getFragile() {
        return fragile;
    }

    public void setFragile(Boolean fragile) {
        this.fragile = fragile;
    }   
}