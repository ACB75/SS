package securityservices.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import securityservices.catalogs.ProductCatalog;
import securityservices.datacheck.Check;
import securityservices.products.Marketable;
import securityservices.products.Product;
import securityservices.products.Service;
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
    
    public int getNumDetails() 
    {
		
    	return details.size();
	}
    
    public int setDetail(String ref, int amount) 
    {
    	int error = -1;
    	
    	if(amount  > 0 && Check.checkBlankOrNull(ref) == 0) 
    	{
    		details.add(new OrderDetail(productCatalog.getMarketable(ref), amount));
    		error = 0;
    	}
    	
		return error;
	} 
    
    public String getDetail(int pos) 
    {
    	String stringDetail = "";
    	
    	if (pos < details.size()) stringDetail = detailToString(pos);
    	
    	return stringDetail;
	}
    
    public String getDetail(String ref)
    {
    	String stringDetail = "";
   
    	if(Check.checkBlankOrNull(ref) == 0) 
    	{
    		
    		int index = getIndexDetail(ref);
    		stringDetail = detailToString(index);
    	}
    	
    	return stringDetail;
	}
    
    public int updateDetail(int pos,int amount) 
    {
    	int error = -1;
    	
    	if (pos < details.size()) 
    	{
    		String stringDetail = getDetail(pos);
    		
    		if(Check.checkBlankOrNull(stringDetail) == 0)
    		{
    			details.get(pos).setAmount(amount);
	    		error = 0;
    		}	
    	}    	
    	
		return error;
	} 
    
    public int updateDetail (String ref, int amount) 
    {
    	int error = -1;
    	
    	if(Check.checkBlankOrNull(ref) == 0 && amount > 1)
    	{
    		int index = getIndexDetail(ref);
    		details.get(index).setAmount(amount);
    	}	
    	
		return error;
	} 
    
    public int deleteDetail(int pos) 
    {
    	int error = -1;
    	
    	if (pos < details.size()) 
    	{
    		String stringDetail = getDetail(pos);
 			
    		if(Check.checkBlankOrNull(stringDetail) == 0)
    		{
    			details.remove(pos);
	    		error = 0;
    		}	
    	}
    	
		return error;
	} 
    
    public int deleteDetail(String ref) 
    {
    	int error = -1;
    	
    	if(Check.checkBlankOrNull(ref) == 0)
    	{
    		int index = getIndexDetail(ref);
    		details.remove(index);
    	}	
    	
		return error;
	} 
    
    public double getPrice() 
    {
    	double price = 0;
    	
    	for(int i = 0; i < details.size() ; i++)
    	{
    		price += details.get(i).getPrice();
    	}
    	
		return price;
	}
    
    private String detailToString(int index)
    {
    	return details.get(index).getAmount() + ", " +
					details.get(index).getName() + ", " +
					details.get(index).getPrice() + ", " +
					details.get(index).getPriceFreeTaxes() + ", " +
					details.get(index).getRef();
    }
    
    private int getIndexDetail(String ref) 
    {
    	int index = -1;
    	
    	for(int i = 0; i < details.size() ; i++)
    	{
    		if(details.get(i).getRef().equals(ref)) index = i;
    	}
    	
    	return index;
    }
}
