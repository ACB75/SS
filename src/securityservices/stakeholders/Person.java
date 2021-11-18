//birthdat con formato de fecha distinto
package securityservices.stakeholders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Person {

    protected String name, ident, email, phone, address;
    protected LocalDate birthday;
    protected DateTimeFormatter birthdayFormatter = DateTimeFormatter.ofPattern("dd'-'MM'-'yyyy");

    public Person() {
    }

    public Person(String name, String code, String email, String phone, String address, String birthdat) {
        this.name = name;
        this.ident = code;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.setBirthday(birthdat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        if (this.birthday != null) {
            return this.birthday.format(this.birthdayFormatter);
        }
        return "";
    }

    public void setBirthday(String birthday) throws DateTimeParseException {
        if (birthday != null && birthday.trim().length() > 7) {
            this.birthday = LocalDate.parse(birthday, this.birthdayFormatter);
        }
    }

    public int yearsOld() {
        LocalDate today = LocalDate.now();
        return (today.minusYears(this.birthday.getYear())).getYear();
    }
}
