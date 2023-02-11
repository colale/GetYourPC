package login.bean;

import java.io.Serializable;

public class UserDataBean implements Serializable {//data to be shown to the user when logout is requested
    private String name;
    private String surname;
    private String email;
    private int id;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }
    public String getRole() {//Also useful for use case associated with content reviewer (unimplemented)
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }


    public void setEmail(String email){this.email = email;}}