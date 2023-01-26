package home;
public class Session {
    private String name;
    private String surname;
    private String email;
    private String status;
    private String role;
    private static volatile Session instance;

    private Session() {}

    public static Session getInstance() {
        if (instance == null) {
            synchronized (Session.class) {
                if (instance == null)
                    instance = new Session();
            }
        }
        return instance;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getRole() {
        return status;
    }

    public void setRole(String role) {
        this.role = role;
    }
}