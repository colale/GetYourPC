package login.model;

import java.io.Serializable;

//User registration has not been implemented but users can be added by following the directions in the README file.

public class Account implements Serializable {
    private int userID;
    private String name;
    private String surname;
    private String role;
    private String email;
    private String password;
    private String status;
    public int getUserID() {
        return userID;
    }

    public void setUserID(int id) {
        this.userID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {//to be used in registration (not implemented)
        return password;
    }

    public void setPassword(String password) {//to be used in registration (not implemented)
        this.password = password;
    }

    public String getStatus() { ////to be used in content reviewer use cases
        return status;
    }

    public void setStatus(String status) {//to be used in other use cases
        this.status = status;
    }
}
