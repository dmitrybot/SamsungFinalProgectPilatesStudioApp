package shinepilates.app.pilatesapp.objects;

import java.util.List;

import shinepilates.app.pilatesapp.model.UserModel;

public class User {
    private Long   id;
    private String firstname;
    private String secondname;
    private String lastname;
    private String password;
    private String email;
    private String phone;
    private int    role;
    private String birthdata;
    private String sex;

    List<Notification> notifications;


    public User(){
        role = 0;
    }

    public User(String phone, String password){
        this.firstname = "";
        this.secondname = "";
        this.lastname = "";
        this.password = password;
        this.email = "";
        this.phone = phone;
        role = 1;
        birthdata = "";
        sex = "0";
    }
    public User(Long id, String firstName, String secondName, String lastName, String Password, String Email, String Phone, int role, String birthData, String sex, List<Notification> notifications) {
        this.id = id;
        this.firstname = firstName;
        this.secondname = secondName;
        this.lastname = lastName;
        this.password = Password;
        this.email = Email;
        this.phone = Phone;
        this.role = role;
        birthdata = birthData;
        this.sex = sex;
        this.notifications = notifications;
    }

    public User(String firstName, String secondName, String lastName, String Password, String Email, String Phone, int role, String birthData, String sex) {
        this.firstname = firstName;
        this.secondname = secondName;
        this.lastname = lastName;
        this.password = Password;
        this.email = Email;
        this.phone = Phone;
        this.role = role;
        birthdata = birthData;
        this.sex = sex;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getSecondName() {
        return secondname;
    }

    public void setSecondName(String secondName) {
        this.secondname = secondName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getFullName(){
        return firstname + " " + secondname;
    }

    public String getBirthData() {
        return birthdata;
    }

    public void setBirthData(String birthData) {
        birthdata = birthData;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel UserToModel(String lastphone){
        return new UserModel(id,
        firstname,
        secondname,
        lastname,
        password,
        email,
        phone,
        role,
        birthdata,
        sex, lastphone, notifications);

    }

    public List<Notification> getNotifications(){
        return notifications;
    }

    public void setNotifications(List<Notification> notifications){
        this.notifications = notifications;
    }
}
