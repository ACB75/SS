package securityservices.operations;

import securityservices.products.Marketable;

public class OrderDetail {

    protected int amount;
    protected Marketable product;

    public OrderDetail() {
    }

    public OrderDetail(Marketable prod, int amount) {
        this.product = prod;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return (this.product.getPrice() + this.product.getTaxes()) * this.amount;
    }

    public double getPriceFreeTaxes() {
        return this.product.getPrice() * this.amount;
    }

    public String getRef() {
        return this.product.getCode();
    }

    public String getName() {
        return this.product.getName();
    }

}
