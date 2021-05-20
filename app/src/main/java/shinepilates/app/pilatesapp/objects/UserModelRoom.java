package shinepilates.app.pilatesapp.objects;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserModelRoom implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    private int role;
    private String birthData;
    private String sex;

    public UserModelRoom(String firstName, String secondName, String lastName, String password, String email, String phone, int role, String birthData, String sex) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.birthData = birthData;
        this.sex = sex;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getRole() {
        return role;
    }

    public String getBirthData() {
        return birthData;
    }

    public String getSex() {
        return sex;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setBirthData(String birthData) {
        this.birthData = birthData;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
