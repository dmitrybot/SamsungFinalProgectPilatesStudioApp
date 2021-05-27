package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.objects.User;
import shinepilates.app.pilatesapp.objects.UserDAO;
import shinepilates.app.pilatesapp.objects.UserDataBase;
import shinepilates.app.pilatesapp.objects.UserModelRoom;

import static android.graphics.Color.RED;

public class AuthorizationFragment extends Fragment {
    TextView goToRegistration;
    Button enter;
    EditText phoneEdit, passwordEdit;
    static AuthorizationFragment instance;
    UserDAO UserDao;
    UserDataBase dataBase;
    UserModelRoom userRoom;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_authorization, container, false);
        goToRegistration = root.findViewById(R.id.goToRegistration);
        enter = root.findViewById(R.id.enterButton);
        phoneEdit = root.findViewById(R.id.phoneEdit);
        passwordEdit = root.findViewById(R.id.passwordEdit);
        dataBase = Room.databaseBuilder(getContext(), UserDataBase.class, "User")
                .allowMainThreadQueries().build();
        UserDao = dataBase.getUserDao();
        //User = MainActivity.getInstance().getUserModelRoom();
        goToRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegistr(goToRegistration);
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnterButton(enter);
            }
        });
        return root;
    }

    public void EnterButton(View v){
        String phone = String.valueOf(phoneEdit.getText());
        String password = String.valueOf(passwordEdit.getText());
        MainActivity.getInstance().Authorisation(phone, password);

    }

    public void AuthRight(User u){
        if (UserDao.getUser() != null) {
            userRoom = UserDao.getUser();
            UserDao.delete(userRoom);
        }
        MainActivity.getInstance().addUserModel(u.getPassword(), u.getPhone());
        MainActivity.getInstance().updateUser(u);
        HomePageFragment.getInstance().generate();
        MainActivity.getInstance().goToFragment(R.id.nav_homepage);
    }

    public void AuthFalse(User u){
        if (u.getPhone().equals("phone")) {
            phoneEdit.setTextColor(RED);
        } else {
            passwordEdit.setTextColor(RED);
        }
    }

    public void goToRegistr(View v){
        MainActivity.getInstance().goToFragment(R.id.nav_registration);
    }

    public static AuthorizationFragment getInstance(){
        return instance;
    }
}