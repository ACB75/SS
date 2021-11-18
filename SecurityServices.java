package securityservices;

import securityservices.catalogs.ProductCatalog;
import securityservices.checkdata.Check;
import securityservices.operations.Order;
import securityservices.operations.Transportable;
import securityservices.products.Equipment;
import securityservices.products.Marketable;
import securityservices.products.Service;
import securityservices.products.Software;
import securityservices.products.Storable;
import securityservices.stakeholders.CompanyClient;

public class SecurityServices {

    public static void main(String[] args) { 
        //EJEMPLO DE LAS POSIBILIDADES DE LAS CLASE ORDER (FALTA POR DESARROLLAR LA GESTION DE LOS ORDERDETAIL)      
        CompanyClient cc = new CompanyClient ("NURIA", "B-21213", "cefpnuria@nuria.cat", "936622113", "Apeles Mestres 48",
                "01-09-1970", "***", 311, 124, "SR", "Educacio");
        
        ProductCatalog prodCatalog = new ProductCatalog();  //CREAMOS EL CATALOGO DE PRODUCTOS DE NUESTRO NEGOCIO
        loadCatalog(prodCatalog);      //LLAMAMOS AL METODO QUE NOS CARGA EL CATALOGO DE PRODUCTOS
        
        System.out.println ("MARKETABLES:");
        Marketable m = prodCatalog.getMarketable("002");
        System.out.println (m.getCode()+";"+m.getName()+";"+m.getPrice()+";"+m.getDetails());
        
        m = prodCatalog.getMarketable("012");
        System.out.println (m.getCode()+";"+m.getName()+";"+m.getPrice()+";"+m.getDetails());
        
        m = prodCatalog.getMarketable("021");
        System.out.println (m.getCode()+";"+m.getName()+";"+m.getPrice()+";"+m.getDetails());
        
        System.out.println ("STORABLES:");
        Storable s = prodCatalog.getStorable("020");
        System.out.println (s.getCode()+";"+s.getDimensions()+";"+s.getWeight());
        s = prodCatalog.getStorable("022");
        System.out.println (s.getCode()+";"+s.getDimensions()+";"+s.getWeight());
        
        Order ord = new Order(prodCatalog, "00011", cc, 0.0, "prepared", "", "09/12/2021-12:00:05", null, "cc", "19/12/2021-20:00:00", "Lluis", "carrer kalea 7");
        System.out.println ("BEGIN DATE: " + ord.getBeginDate());
        System.out.println ("FINISH DATE: " + ord.getFinishDate());
        
        Transportable t = ord.getTranportable();
        System.out.println (t.getCode()+";"+t.getReceiverName() +";"+t.getDeliveryAddress()+";"+t.getDeliveryDate()+";"+t.getDimensions()+";"+t.getWeight());
        
    }
    
    private static void loadCatalog (ProductCatalog prodCatalog) {
//Service(String code, String name, String type, String maker, String description, double price, double taxes, String periodicity, String conditions)  
        prodCatalog.addCatalog(new Service("001", "Mantenimiento", "Informatico", "SS", "desc", 1000.0, 0.0, "mensual", "none"));
        prodCatalog.addCatalog(new Service("002", "Reparacion", "Informatico", "SS", "desc", 200.0, 0.0, "semanal", "none"));
        prodCatalog.addCatalog(new Service("003", "Seguridad", "Informatico", "SS", "desc", 2000.0, 0.0, "anual", "none"));
//Software(String code, String name, String type, String maker, String description, double price, double taxes, String version, String os, String medium)        
        prodCatalog.addCatalog(new Software("010", "Antivirus", "Informatico", "SS", "desc", 29.0, 0.0, "1.7", "linux", "link"));
        prodCatalog.addCatalog(new Software("011", "Firewall", "Informatico", "SS", "desc", 49.0, 0.0, "3.3", "windows", "link"));
        prodCatalog.addCatalog(new Software("012", "Proxy", "Informatico", "SS", "desc", 30.0, 0.0, "2.1", "ios", "link"));
//Equipment(String code, String name, String type, String maker, String description, Double price, Double taxes, Double high, Double wide, Double deep, Double weight, Boolean fragile, String function, String components, Integer power) 
        prodCatalog.addCatalog(new Equipment("020", "Server", "Informatico", "SS", "desc", 3000.0, 0.0, 0.8, 0.6, 0.45, 7.1, true, "dataservices", "hw list", 800));
        prodCatalog.addCatalog(new Equipment("021", "NetworkAnalyzer", "Informatico", "SS", "desc", 1000.0, 0.0, 0.8, 0.6, 0.45, 4.5, true, "Segurity", "hw list", 600));
        prodCatalog.addCatalog(new Equipment("022", "Firewall", "Informatico", "SS", "desc", 30.0, 600.0, 0.8, 0.6, 0.45, 3.8, true, "firewall", "hw list", 400));        
    }
}
