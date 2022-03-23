package securityservices;

import securityservices.core.components.client.CompanyClient;
import securityservices.core.components.equipment.Equipment;
import securityservices.core.components.order.Order;
import securityservices.core.components.shared.catalogs.ProductCatalog;
import securityservices.core.components.shared.operations.Transportable;
import securityservices.core.components.shared.products.Marketable;
import securityservices.core.components.shared.products.Storable;

public class SecurityServices {

    public static void main(String[] args) { 
        //EJEMPLO DE LAS POSIBILIDADES DE LAS CLASE ORDER (FALTA POR DESARROLLAR LA GESTION DE LOS ORDERDETAIL)      
        CompanyClient cc = new CompanyClient("NURIA", "B-21213", "cefpnuria@nuria.cat", "936622113", "Apeles Mestres 48",
        									 "01-09-1970", "***", 311, 124, "SR", "Educacio");
        
        ProductCatalog prodCatalog = new ProductCatalog();  //CREAMOS EL CATALOGO DE PRODUCTOS DE NUESTRO NEGOCIO
        loadCatalog(prodCatalog);      //LLAMAMOS AL METODO QUE NOS CARGA EL CATALOGO DE PRODUCTOS
        
        System.out.println ("MARKETABLES:");
        Marketable m = prodCatalog.getMarketable("020");
        System.out.println (m.getCode()+";"+m.getName()+";"+m.getPrice()+";"+m.getDetails());
        
        System.out.println ("STORABLES:");
        Storable s = prodCatalog.getStorable("020");
        System.out.println (s.getCode()+";"+s.getDimensions()+";"+s.getWeight());
        s = prodCatalog.getStorable("022");
        System.out.println (s.getCode()+";"+s.getDimensions()+";"+s.getWeight());
        
        Order order = new Order(prodCatalog, "00011", cc, 0.0, "prepared", "", "09/12/2021-12:00:05", null, "cc", "19/12/2021-20:00:00", "Lluis", "carrer kalea 7");
        System.out.println ("BEGIN DATE: " + order.getBeginDate());
        System.out.println ("FINISH DATE: " + order.getFinishDate());
        
        Transportable t = order.getTranportable();
        System.out.println (t.getCode()+";"+t.getReceiverName() +";"+t.getDeliveryAddress()+";"+t.getDeliveryDate()+";"+t.getDimensions()+";"+t.getWeight());
        
        int error = order.setDetail("020", 1);
        
        System.out.println ("error setDetail: " + error);
        System.out.println (order.getDetail(0));
        
        error = order.updateDetail(0, 2);
        
        System.out.println ("error updateDetail: " + error);
        System.out.println (order.getDetail("020"));
    }
    
    private static void loadCatalog (ProductCatalog prodCatalog) 
    {
        //Equipment(String code, String name, String type, String maker, String description, Double price, Double taxes, Double high, Double wide, Double deep, Double weight, Boolean fragile, String function, String components, Integer power) 
        prodCatalog.addCatalog(new Equipment("020", "Server", "Informatico", "SS", "desc", 3000.0, 0.0, 0.8, 0.6, 0.45, 7.1, true, "dataservices", "hw list", 800));
        prodCatalog.addCatalog(new Equipment("021", "NetworkAnalyzer", "Informatico", "SS", "desc", 1000.0, 0.0, 0.8, 0.6, 0.45, 4.5, true, "Segurity", "hw list", 600));
        prodCatalog.addCatalog(new Equipment("022", "Firewall", "Informatico", "SS", "desc", 30.0, 600.0, 0.8, 0.6, 0.45, 3.8, true, "firewall", "hw list", 400));        
    }
}