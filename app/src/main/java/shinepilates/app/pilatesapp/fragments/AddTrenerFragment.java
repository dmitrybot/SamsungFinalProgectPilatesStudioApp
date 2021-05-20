package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.objects.TrenersItem;

public class AddTrenerFragment extends Fragment {
    EditText addName;
    EditText addPosition;
    EditText adddescription;
    Button addTrener;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_trener, container, false);
        addName = root.findViewById(R.id.addTrenerName);
        addPosition = root.findViewById(R.id.addPosition);
        adddescription = root.findViewById(R.id.addDescription);
        addTrener = root.findViewById(R.id.addTren);
        addTrener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text = String.valueOf(addName.getText());
                String Text2 = String.valueOf(addPosition.getText());
                String Text3 = String.valueOf(adddescription.getText());
                TrenersItem treners = new TrenersItem();
                treners.setTrenersname(Text);
                treners.setTrenerspos(Text2);
                treners.setTrenersdescr(Text3);
                MainActivity.getInstance().addTrener(treners);
            }
        });
        return root;
    }
}
