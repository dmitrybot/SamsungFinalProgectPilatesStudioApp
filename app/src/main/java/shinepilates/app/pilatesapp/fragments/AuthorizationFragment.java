package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.objects.User;

import static android.graphics.Color.RED;

public class AuthorizationFragment extends Fragment {
    TextView goToRegistration;
    Button enter;
    EditText phoneEdit, passwordEdit;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_authorization, container, false);
        goToRegistration = root.findViewById(R.id.goToRegistration);
        enter = root.findViewById(R.id.enterButton);
        phoneEdit = root.findViewById(R.id.phoneEdit);
        passwordEdit = root.findViewById(R.id.passwordEdit);

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
        boolean k = true;
        for (User u: MainActivity.getInstance().getUsers()){
            if (u.getPhone().equals(phone) && u.getPassword().equals(password)){
                k = false;
                MainActivity.getInstance().updateUser(u);
                HomePageFragment.getInstance().generate();
                MainActivity.getInstance().goToFragment(R.id.nav_homepage);
                break;
            }
        }
        if (k){
            phoneEdit.setTextColor(RED);
            passwordEdit.setTextColor(RED);
        }
    }

    public void goToRegistr(View v){
        MainActivity.getInstance().goToFragment(R.id.nav_registration);
    }
}