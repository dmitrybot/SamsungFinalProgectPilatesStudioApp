package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.objects.User;

public class HomePageFragment extends Fragment {
    TextView HelloText;
    Button OwnData, Rulles, BuyAb, MyRecords, Loginization;
    private static HomePageFragment instance;
    User user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
    }

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
        OwnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(OwnData);
            }
        });
        Rulles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(Rulles);
            }
        });
        BuyAb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(BuyAb);
            }
        });
        MyRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(MyRecords);
            }
        });



        return root;
    }
    public void onClickButton(View v){
        switch (v.getId()){
            case R.id.owndata:
                if (user.getRole() == 1){
                    MainActivity.getInstance().goToFragment(R.id.nav_owndata);
                }
                break;
            case R.id.buyab:
                break;
            case R.id.myrecords:
                break;
            case R.id.rulles:
                if (user.getRole() == 1){
                    MainActivity.getInstance().goToFragment(R.id.nav_rulles);
                }
                break;
            case R.id.loginization:
                if (user.getRole() == 0){
                    MainActivity.getInstance().goToFragment(R.id.nav_authorization);
                } else {
                    MainActivity.getInstance().Exit();
                    user = MainActivity.getInstance().getUser();
                    generate();
                }
                break;
        }
    }

    public void generate(){
        user = MainActivity.getInstance().getUser();
        if (user.getRole() == 0){
            OwnData.setVisibility(View.GONE);
            Rulles.setVisibility(View.GONE);
            BuyAb.setVisibility(View.GONE);
            MyRecords.setVisibility(View.GONE);
            Loginization.setText("Войти в учетную запись");
            HelloText.setText("Добро пожаловать");
        } else if (user.getRole() == 1){
            OwnData.setVisibility(View.VISIBLE);
            OwnData.setText("Личные данные");
            Rulles.setVisibility(View.VISIBLE);
            Rulles.setText("Правила студии");
            BuyAb.setVisibility(View.VISIBLE);
            MyRecords.setVisibility(View.VISIBLE);
            Loginization.setText("Выйти из учетной записи");
            if (!user.getFullName().equals(" ")) {
                HelloText.setText("Добро пожаловать, " + user.getFullName() + " !");
            } else {
                HelloText.setText("Добро пожаловать");
            }
        } else if (user.getRole() == 2){
            OwnData.setVisibility(View.VISIBLE);
            OwnData.setText("Запросы");
            Rulles.setVisibility(View.VISIBLE);
            Rulles.setText("Клиенты");
            BuyAb.setVisibility(View.GONE);
            MyRecords.setVisibility(View.GONE);
            Loginization.setText("Выйти из учетной записи");
            if (!user.getFullName().equals(" ")) {
                HelloText.setText("Добро пожаловать, " + user.getFullName() + " !");
            } else {
                HelloText.setText("Добро пожаловать");
            }
        }
    }

    public static HomePageFragment getInstance(){
        return instance;
    }

    public void updateUser(){
        user = MainActivity.getInstance().getUser();
    }

}
