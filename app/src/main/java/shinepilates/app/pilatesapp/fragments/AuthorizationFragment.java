package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;

public class AuthorizationFragment extends Fragment {
    TextView goToRegistration;
    Button enter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_authorization, container, false);
        goToRegistration = root.findViewById(R.id.goToRegistration);
        enter = root.findViewById(R.id.enterButton);

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
        MainActivity.getInstance().goToFragment(R.id.nav_homepage);
    }

    public void goToRegistr(View v){
        MainActivity.getInstance().goToFragment(R.id.nav_registration);
    }
}