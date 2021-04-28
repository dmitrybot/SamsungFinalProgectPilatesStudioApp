package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;

public class HomePageFragment extends Fragment {
    TextView HelloText;
    Button OwnData, Rulles, BuyAb, MyRecords, Loginization;
    int k = 1;
    String s = "Дмитрий Тапанович";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_homepage, container, false);
        HelloText = root.findViewById(R.id.hellotext);
        OwnData = root.findViewById(R.id.owndata);
        Rulles = root.findViewById(R.id.rulles);
        BuyAb = root.findViewById(R.id.buyab);
        MyRecords = root.findViewById(R.id.myrecords);
        Loginization = root.findViewById(R.id.loginization);
        generate();

        Loginization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(Loginization);
            }
        });


        return root;
    }
    public void onClickButton(View v){
        switch (v.getId()){
            case R.id.owndata:
                break;
            case R.id.buyab:
                break;
            case R.id.myrecords:
                break;
            case R.id.rulles:
                break;
            case R.id.loginization:
                if (k == 1){
                    MainActivity.getInstance().goToFragment(R.id.nav_authorization);
                } else {
                    k = 1;
                    generate();
                }
                break;
        }
    }

    public void generate(){
        if (k == 1){
            OwnData.setVisibility(View.GONE);
            Rulles.setVisibility(View.GONE);
            BuyAb.setVisibility(View.GONE);
            MyRecords.setVisibility(View.GONE);
            Loginization.setText("Войти в учетную запись");
            HelloText.setText("Добро пожаловать");
        } else {
            OwnData.setVisibility(View.VISIBLE);
            Rulles.setVisibility(View.VISIBLE);
            BuyAb.setVisibility(View.VISIBLE);
            MyRecords.setVisibility(View.VISIBLE);
            Loginization.setText("Выйти из учетной записи");
            HelloText.setText("Добро пожаловать, " + s + "!");
        }
    }

}
