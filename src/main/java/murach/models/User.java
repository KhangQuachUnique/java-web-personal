package murach.models;  // hoặc để chung 1 package, không cần 2 cái tách biệt

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String dob;          // ngày sinh
    private String heardFrom;    // nghe từ đâu
    private String wantsUpdates; // muốn cập nhật
    private Boolean emailOK;      // email có hợp lệ không / có đồng ý nhận mail không
    private String contactVia;    // liên lạc qua gì (phone/email...)

    // Constructor mặc định
    public User() {
        this("", "", "", "", "", "", false, "");
    }

    // Constructor đầy đủ
    public User(String firstName, String lastName, String email, String dob,
                String heardFrom, String wantsUpdates, Boolean emailOK, String contactVia) {
        this.firstName    = firstName;
        this.lastName     = lastName;
        this.email        = email;
        this.dob          = dob;
        this.heardFrom    = heardFrom;
        this.wantsUpdates = wantsUpdates;
        this.emailOK      = emailOK;
        this.contactVia   = contactVia;
    }

    // Getters & Setters
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

    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHeardFrom() {
        return heardFrom;
    }
    public void setHeardFrom(String heardFrom) {
        this.heardFrom = heardFrom;
    }

    public String getWantsUpdates() {
        return wantsUpdates;
    }
    public void setWantsUpdates(String wantsUpdates) {
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

    // tiện ích in ra thông tin
    @Override
    public String toString() {
        return String.format("User[firstName=%s, lastName=%s, email=%s, dob=%s, heardFrom=%s, wantsUpdates=%b, emailOK=%b, contactVia=%s]",
                firstName, lastName, email, dob, heardFrom, wantsUpdates, emailOK, contactVia);
    }

}
