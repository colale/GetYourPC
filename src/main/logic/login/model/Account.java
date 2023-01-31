package login.model;

import java.io.Serializable;
//Questa classe viene utilizzata solamente per inserire utenti, leggere file README per informazioni
public class Account implements Serializable {
    int userID=0;
    String name="";
    String surname="";
    String role="";
    String email="";
    String password="";
    String status="";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
