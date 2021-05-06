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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.objects.User;

public class OwnDataFragment extends Fragment {
    EditText firstName, secondName, lastName, Phone, birthData, Email;
    Spinner spinnerSex;
    Button update;
    User user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = MainActivity.getInstance().getUser();
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

        firstName.setText(user.getFirstName());
        secondName.setText(user.getSecondName());
        lastName.setText(user.getLastName());
        Phone.setText(user.getPhone());
        birthData.setText(user.getBirthData());
        Email.setText(user.getEmail());
        spinnerSex.setSelection(Integer.parseInt(user.getSex()));

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().updateUser(String.valueOf(firstName.getText()), String.valueOf(secondName.getText()), String.valueOf(lastName.getText()), user.getPassword(), String.valueOf(Email.getText()), String.valueOf(Phone.getText()), user.getRole(), String.valueOf(birthData.getText()), String.valueOf(spinnerSex.getSelectedItemPosition()));
                HomePageFragment.getInstance().updateUser();
                MainActivity.getInstance().goToFragment(R.id.nav_homepage);
            }
        });

        return root;
    }
}
