package murach.models;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String heardFrom;
    private Boolean wantsUpdates;
    private Boolean emailOK;
    private String contactVia;

    // Constructor mặc định
    public User() {
        this("", "", "", "", "", false, false, "");
    }

    // Constructor đầy đủ
    public User(String firstName, String lastName, String email, String dob, String heardFrom, Boolean wantsUpdates, Boolean emailOK, String contactVia) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
        this.dob       = dob;
        this.heardFrom = heardFrom;
        this.emailOK     = emailOK;
        this.wantsUpdates = wantsUpdates;
        this.contactVia = contactVia;
    }

    // Getter & Setter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeardFrom() {
        return heardFrom;
    }
    public void setHeardFrom(String heardFrom) {
        this.heardFrom = heardFrom;
    }
    public Boolean getWantsUpdates() {
        return wantsUpdates;
    }
    public void setWantsUpdates(Boolean wantsUpdates) {
        this.wantsUpdates = wantsUpdates;
    }
    public Boolean getEmailOK() {
        return emailOK;
    }
    public void setEmailOK(Boolean emailOK) {
        this.emailOK = emailOK;
    }
    public String getContactVia() {
        return contactVia;
    }

    public void setContactVia(String contactVia) {
        this.contactVia = contactVia;
    }
    // Thêm tiện ích để in ra thông tin User
    @Override
    public String toString() {
        return String.format("User[firstName=%s, lastName=%s, email=%s, dob=%s, heardFrom=%s, wantsUpdates=%b, emailOK=%b, contactVia=%s]",
                firstName, lastName, email, dob, heardFrom, wantsUpdates, emailOK, contactVia);
    }
}
