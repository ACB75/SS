package securityservices.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import securityservices.catalogs.ProductCatalog;
import securityservices.stakeholders.StakeHolder;

public class Order extends Operation {

    protected String paymentType;
    protected LocalDateTime paymentDate;
    protected ArrayList<OrderDetail> details = new ArrayList();
    protected TransportableOrder transport = null;
    protected ProductCatalog productCatalog;

    public Order(ProductCatalog catalog) {
        this.productCatalog = catalog;
    }

    public Order(ProductCatalog catalog, String code, StakeHolder interested, double value, double surcharges,
            String status, String comments, String beginDate, String finishDate,
            String paymentType, String paymentDate) {
        super(code, interested, value, surcharges, status, comments, beginDate, finishDate);
        this.productCatalog = catalog;
        this.paymentType = paymentType;
        this.setPaymentDate(paymentDate);
    }

    public Order(ProductCatalog catalog, String code, StakeHolder interested, double surcharges, String status, String comments,
            String beginDate, String finishDate, String paymentType, String paymentDate, String receiverName, String deliveryAddress) {
        super(code, interested, 0.0, surcharges, status, comments, beginDate, finishDate);
        this.productCatalog = catalog;
        this.paymentType = paymentType;
        this.setPaymentDate(paymentDate);
        this.transport = new TransportableOrder(code, null, deliveryAddress, receiverName, null);

    }

    private void prepareTransport() {
        this.transport.setCode(this.code);
        this.transport.setReceiverName(this.interested.getName());
        this.transport.setDeliveryAddress(this.interested.getAddress());
        
                // ... CONTINUARA ....
                
    }

    public Transportable getTranportable() {
        if (this.transport != null) {
            this.prepareTransport();
        }
        return this.transport;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentDate() {
        if (this.paymentDate != null) {
            return this.paymentDate.format(this.dateTimeFormatter);
        }
        return "";
    }

    public void setPaymentDate(String paymentDate) throws DateTimeParseException {
        if (paymentDate != null && paymentDate.trim().length() > 0) {
            this.paymentDate = LocalDateTime.parse(paymentDate, this.dateTimeFormatter);
        }
    }
}
