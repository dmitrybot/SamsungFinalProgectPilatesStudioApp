package shinepilates.app.pilatesapp.fragments;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.objects.User;

import static android.graphics.Color.RED;

public class OwnDataFragment extends Fragment {
    EditText firstName, secondName, lastName, Phone, birthData, Email;
    TextView phone;
    Spinner spinnerSex;
    Button update;
    User user;

    private static OwnDataFragment instance;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = MainActivity.getInstance().getUser();
        instance = this;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_owndata, container, false);
        firstName = root.findViewById(R.id.firstnameEdit);
        secondName = root.findViewById(R.id.secondnameEdit);
        lastName = root.findViewById(R.id.lastnameEdit);
        Phone = root.findViewById(R.id.phoneEdit);
        birthData = root.findViewById(R.id.birthdataEdit);
        Email = root.findViewById(R.id.emailEdit);
        spinnerSex = root.findViewById(R.id.spinner_sex);
        update = root.findViewById(R.id.update);
        phone = root.findViewById(R.id.phone);

        if(user.getSex() != null){
            spinnerSex.setSelection(Integer.parseInt(user.getSex()));
        }
        if(user.getEmail() != null){
            Email.setText(user.getEmail());
        }
        if(user.getEmail() != null){
            Email.setText(user.getEmail());
        }
        if(user.getBirthData() != null){
            birthData.setText(user.getBirthData());
        }
        if(user.getPhone() != null){
            Phone.setText(user.getPhone());
        }
        if(user.getLastName() != null){
            lastName.setText(user.getLastName());
        }if(user.getSecondName() != null){
            secondName.setText(user.getSecondName());
        }
        if(user.getFirstName() != null){
            firstName.setText(user.getFirstName());
        }

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().updateUser(String.valueOf(firstName.getText()), String.valueOf(secondName.getText()), String.valueOf(lastName.getText()), user.getPassword(), String.valueOf(Email.getText()), String.valueOf(Phone.getText()), user.getRole(), String.valueOf(birthData.getText()), String.valueOf(spinnerSex.getSelectedItemPosition()));
            }
        });

        return root;
    }

    public static OwnDataFragment getInstance(){
        return instance;
    }

    public void setPhoneExeption(){
        phone.setText("Введенный номер уже зарегистрирован");
        phone.setTextColor(RED);
    }

}
