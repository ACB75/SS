package securityservices.core.components.shared.operations;

import securityservices.core.components.shared.products.Storable;

public interface Transportable extends Storable {
    public String getDeliveryAddress();
    public String getDeliveryDate();
    public String getReceiverName();
    public String getTransporter();
}
