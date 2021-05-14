package shinepilates.app.pilatesapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

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
    private String lastphone;

    public UserModel(Long id, String firstname, String secondname, String lastname, String password, String email, String phone,
            int role, String birthdata, String sex, String lastphone){
        this.id         = id;
        this.firstname  = firstname;
        this.secondname = secondname;
        this.lastname   = lastname;
        this.password   = password;
        this.email      = email;
        this.phone      = phone;
        this.role       = role;
        this.birthdata  = birthdata;
        this.sex        = sex;
        this.lastphone  = lastphone;
    }
}