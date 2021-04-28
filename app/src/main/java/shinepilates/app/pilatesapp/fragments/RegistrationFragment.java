package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;

public class RegistrationFragment extends Fragment {
    Button creation;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_registration, container, false);
        creation = root.findViewById(R.id.create);

        creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Create(creation);
            }
        });

        return root;
    }

    public void Create(View v){
        MainActivity.getInstance().goToFragment(R.id.nav_homepage);
    }
}