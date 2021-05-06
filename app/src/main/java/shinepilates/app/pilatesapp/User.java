package shinepilates.app.pilatesapp;

public class User {
    private String Name;
    private String Password;
    private String Email;
    private String Phone;
    private String Role;

    public User(String Name, String Password, String Email, String Phone, String role) {
        this.Name = Name;
        this.Password = Password;
        this.Email = Email;
        this.Phone = Phone;
        Role = role;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
