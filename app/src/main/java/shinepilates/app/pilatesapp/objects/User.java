package shinepilates.app.pilatesapp.objects;

public class User {
    private String firstName;
    private String secondName;
    private String lastName;
    private String Password;
    private String Email;
    private String Phone;
    private int Role;
    private String BirthData;
    private String Sex;


    public User(){
        Role = 0;
    }

    public User(String phone, String password){
        this.firstName = "";
        this.secondName = "";
        this.lastName = "";
        this.Password = password;
        this.Email = "";
        this.Phone = phone;
        Role = 1;
        BirthData = "";
        Sex = "0";
    }
    public User(String firstName, String secondName, String lastName, String Password, String Email, String Phone, int role, String birthData, String sex) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.Password = Password;
        this.Email = Email;
        this.Phone = Phone;
        Role = role;
        BirthData = birthData;
        Sex = sex;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int role) {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getBirthData() {
        return BirthData;
    }

    public void setBirthData(String birthData) {
        BirthData = birthData;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }
}
