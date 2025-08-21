package murach.business;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;

    // Constructor mặc định
    public User() {
        this("", "", "");
    }

    // Constructor đầy đủ
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
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

    // Thêm tiện ích để in ra thông tin User
    @Override
    public String toString() {
        return String.format("User[firstName=%s, lastName=%s, email=%s]",
                firstName, lastName, email);
    }
}
