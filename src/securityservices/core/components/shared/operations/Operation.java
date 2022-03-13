package securityservices.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import securityservices.stakeholders.StakeHolder;

public abstract class Operation {
    protected StakeHolder interested;
    protected String code, status, comments;
    protected double value, surcharges;
    protected LocalDateTime initDate, finishDate;
    protected DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy'-'HH:mm:ss");

    public Operation() {
    }

    public Operation(String code, StakeHolder interested, double value, double surcharges, 
            String status, String comments, String initDate, String finishDate) {
        this.code = code;
        this.interested = interested;
        this.value = value;
        this.surcharges = surcharges;
        this.status = status;
        this.comments = comments;
        this.setBeginDate(initDate);
        this.setFinishDate(finishDate);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StakeHolder getInterested() {
        return interested;
    }

    public void setInterested(StakeHolder interested) {
        this.interested = interested;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getSurcharges() {
        return surcharges;
    }

    public void setSurcharges(double surcharges) {
        this.surcharges = surcharges;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getBeginDate() {
        if (this.initDate != null) {
            return this.initDate.format(this.dateTimeFormatter);
        } 
        return "";
    }

    public void setBeginDate(String beginDate) throws DateTimeParseException {
        if (beginDate != null && beginDate.trim().length() > 0) {
            this.initDate = LocalDateTime.parse(beginDate, this.dateTimeFormatter);
        }
    }

    public String getFinishDate() {
        if (this.finishDate != null) {
            return this.finishDate.format(this.dateTimeFormatter);
        } 
        return "";
    }

    public void setFinishDate(String finishDate) throws DateTimeParseException{
        if (finishDate != null && finishDate.trim().length() > 0) {
            this.finishDate = LocalDateTime.parse(finishDate, this.dateTimeFormatter);
        }
    }
}
