package securityservices.products;

import securityservices.shared.PhysicalData;

public abstract class PhysicalProduct extends Product implements Storable {
    
    protected PhysicalData physics;

    public PhysicalProduct() {
        this.physics = new PhysicalData();
    }

    public PhysicalProduct(String code, String name, String type, String maker, String description, Double price, 
            double taxes, Double high, Double wide, Double deep, Double weight, Boolean fragile) {
        super(code, name, type, maker, description, price, taxes);

        physics = new PhysicalData( high, wide, deep, weight, fragile);
    }

    public Double getHigh() {
        return this.physics.getHigh();
    }

    public void setHigh(Double high) {
        this.physics.setHigh(high);;
    }

    public Double getWide() {
        return this.physics.getWide();
    }

    public void setWide(Double wide) {
        this.physics.setWide(wide);
    }

    public Double getDeep() {
        return this.physics.getDeep();
    }

    public void setDeep(Double deep) {
        this.physics.setDeep(deep);
    }

    @Override
    public Double getWeight() {
        return this.physics.getWeight();
    }

    public void setWeight(Double weight) {
        this.physics.setWeight(weight);
    }

    @Override
    public Boolean isFragile() {
        return this.physics.getFragile();
    }

    public void setFragile(Boolean fragile) {
        this.physics.setFragile(fragile);
    }   
}