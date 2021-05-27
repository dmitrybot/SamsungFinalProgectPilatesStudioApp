package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.objects.UserDAO;
import shinepilates.app.pilatesapp.objects.UserDataBase;
import shinepilates.app.pilatesapp.objects.UserModelRoom;

import static android.graphics.Color.RED;

public class RegistrationFragment extends Fragment {
    Button creation;
    EditText phone, password, password2;
    CheckBox checkBoxUsersAgreenment, checkBoxConfidentialPolitics;
    TextView UsersAgreenment, ConfidentialPolitics, textView;
    private static RegistrationFragment instance;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        instance = this;
    }
    private UserDAO UserDao;
    private UserModelRoom userRoom;
    private UserDataBase dataBase;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_registration, container, false);
        creation = root.findViewById(R.id.create);
        checkBoxUsersAgreenment = root.findViewById(R.id.checkBox_users_agreenment);
        checkBoxConfidentialPolitics = root.findViewById(R.id.checkBox_confidetial_politic);
        UsersAgreenment = root.findViewById(R.id.users_agreenment);
        ConfidentialPolitics = root.findViewById(R.id.confidetial_politic);
        phone = root.findViewById(R.id.phoneEdit);
        password = root.findViewById(R.id.passwordEdit);
        password2 = root.findViewById(R.id.passwordEdit2);
        textView = root.findViewById(R.id.textView);
        dataBase = Room.databaseBuilder(getContext(), UserDataBase.class, "User")
                .allowMainThreadQueries().build();
        UserDao = dataBase.getUserDao();



        creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Create(creation);


            }
        });
        UsersAgreenment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().goToFragment(R.id.nav_users_agreenment);
            }
        });
        ConfidentialPolitics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().goToFragment(R.id.nav_confidential_politic);
            }
        });

        return root;
    }

    public void Create(View v){
        String ph = String.valueOf(phone.getText());
        String pas1 = String.valueOf(password.getText());
        String pas2= String.valueOf(password2.getText());
        if (pas1.equals(pas2) && checkBoxConfidentialPolitics.isChecked() && checkBoxUsersAgreenment.isChecked()) {
            MainActivity.getInstance().addUser(ph, pas1);
            if (UserDao.getUser() != null){
                userRoom = UserDao.getUser();
                UserDao.delete(userRoom);
            }
            MainActivity.getInstance().addUserModel(pas1, ph);
            //MainActivity.getInstance().addUserModel(ph, pas1);
            /*if (UserDao.getUser() != null){
                UserDao.delete(userRoom);
                MainActivity.getInstance().addUserModel(null,null, null, pas1, null,ph, 0, null, null);
            }*/
        }else if(ph.equals("") || pas1.equals("") || pas2.equals("")){
            textView.setTextColor(RED);
            textView.setTextSize(15);
            textView.setText("Заполните все поля");
        } else if (!pas1.equals(pas2)){
            textView.setTextColor(RED);
            textView.setTextSize(15);
            textView.setText("Пароли не совпадают");
        } else if (!checkBoxConfidentialPolitics.isChecked()){
            textView.setTextColor(RED);
            textView.setTextSize(15);
            textView.setText("Примите политику конфиденциальности,\nчтобы мы смогли вас зарегистрировать");
        } else if (!checkBoxUsersAgreenment.isChecked()){
            textView.setTextColor(RED);
            textView.setTextSize(15);
            textView.setText("Примите пользовательское соглашение,\nчтобы мы смогли вас зарегистрировать");
        }
    }

    public static RegistrationFragment getInstance(){
        return instance;
    }

    public void wrongTry(String s){
        textView.setTextColor(RED);
        textView.setTextSize(15);
        textView.setText(s);
    }
}