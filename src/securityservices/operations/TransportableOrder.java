package securityservices.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import securityservices.shared.PhysicalData;

public class TransportableOrder implements Transportable {

    protected String code, transporter, deliveryAddress, receiverName;
    protected LocalDateTime deliveryDate;
    protected DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy'-'HH:mm:ss");
    protected PhysicalData physics;
    protected ArrayList<TransportableDetail> details = new ArrayList();

    public TransportableOrder() {
        this.physics = new PhysicalData();
    }

    public TransportableOrder(String code, String transporter, String deliveryAddres, String receiverName, String deliveryDate) {
        this.code = code;
        this.transporter = transporter;
        this.deliveryAddress = deliveryAddres;
        this.receiverName = receiverName;
        this.physics = new PhysicalData();
        this.setDeliveryDate(deliveryDate);
    }

    public TransportableOrder(String code, String transporter, String deliveryAddres, String receiverName, String deliveryDate,
            Double high, Double wide, Double deep, Double weight, Boolean fragile) {
        this.code = code;
        this.transporter = transporter;
        this.deliveryAddress = deliveryAddres;
        this.receiverName = receiverName;
        this.physics = new PhysicalData(high, wide, deep, weight, fragile);
        this.setDeliveryDate(deliveryDate);
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
       
    public String getDeliveryDate() {
        if (this.deliveryDate != null) {
            return this.deliveryDate.format(this.dateTimeFormatter);
        }
        return "";
    }

    public void setDeliveryDate(String receptionDate) throws DateTimeParseException {
        if (receptionDate != null && receptionDate.trim().length() > 0) {
            this.deliveryDate = LocalDateTime.parse(receptionDate, this.dateTimeFormatter);
        }
    }

    @Override
    public String getTransporter() {
        return this.transporter;
    }

    public void setTransporter(String transporter) {
        this.transporter = transporter;
    }

    @Override
    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddres) {
        this.deliveryAddress = deliveryAddres;
    }

    @Override
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Double getHigh() {
        return this.physics.getHigh();
    }

    public void setHigh(Double high) {
        this.physics.setHigh(high);
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

    @Override
    public String getDimensions() {
        return "W:" + this.physics.getWide() + ";D:" + this.physics.getDeep() + ";H:" + this.physics.getHigh();
    }

    @Override
    public Double getVolum() {
        return this.physics.getHigh() * this.physics.getWide() * this.physics.getDeep();
    }
}
