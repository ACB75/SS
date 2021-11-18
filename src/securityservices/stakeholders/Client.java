package securityservices.stakeholders;

public class Client extends Person implements StakeHolder{
    protected String password;
    protected int clientCode, equipments;

    public Client() {
    }

    public Client(String name, String ident, String email, String phone, String address, String birthday,
                    String password, int clientCode, int numEquipments) {
        super(name, ident, email, phone, address, birthday);
        this.password = password;
        this.clientCode = clientCode;
        this.equipments = numEquipments;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClientCode() {
        return clientCode;
    }

    public void setClientCode(int clientCode) {
        this.clientCode = clientCode;
    }

    public int getEquipments() {
        return equipments;
    }

    public void setEquipments(int equipments) {
        this.equipments = equipments;
    }

    @Override
    public String getDetails() {
        return "clientcode:" + this.clientCode + ";equipments:" + this.equipments;
    }

    @Override
    public String getCode() {
        return this.ident;
    }
}