package securityservices.stakeholders;

public class Employee extends Person {

    protected String specialities;
    protected String rol;

    public Employee() {
    }

    public Employee(String name, String code, String email, String phone, String address, 
            String birthday, String specialities, String rol ) {
        super(name, code, email, phone, address, birthday);
        this.specialities = specialities;
        this.rol = rol;
    }

    public String getSpecialities() {
        return specialities;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
