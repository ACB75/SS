package securityservices.operations;

import securityservices.products.Storable;

public interface Transportable extends Storable {
    public String getDeliveryAddress();
    public String getDeliveryDate();
    public String getReceiverName();
    public String getTransporter();
}
