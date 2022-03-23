package securityservices.core.components.client;

import securityservices.core.components.shared.stakeholders.Company;
import securityservices.core.components.shared.stakeholders.StakeHolder;

public class CompanyClient extends Client implements StakeHolder {

    protected Company companyData = new Company();

    public CompanyClient() {
    }

    public CompanyClient(String name, String ident, String email, String phone, String address, String birthday,
            String password, int clientCode, int numEquipments, String socialReason, String type) {
        super(name, ident, email, phone, address, birthday, password, clientCode, numEquipments);

        this.companyData.setSocialReason(socialReason);
        this.companyData.setType(type);
    }

    public String getSocialReason() {
        return this.companyData.getSocialReason();
    }

    public void setSocialReason(String socialReason) {
        this.companyData.setSocialReason(socialReason);
    }

    public String getType() {
        return this.companyData.getType();
    }

    public void setType(String type) {
        this.companyData.setType(type);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ";companyType" + this.companyData.getType();
    }

    @Override
    public String getCode() {
        return this.getCode() + "(" + this.clientCode + ")";
    }
}
