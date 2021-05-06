package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.adapters.TrenersAdapter;
import shinepilates.app.pilatesapp.objects.TrenersItem;

public class TrenersFragment extends Fragment {
    private RecyclerView RecyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager LayoutManager;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_treners, container, false);

        ArrayList<TrenersItem> trenersList  = new ArrayList<>();
        trenersList.add( new TrenersItem(R.drawable.ic_android_test, "Карпов Евгений", "Главный Тренер", "Мужик впринципе хороший, тренерует неплохо, но задолбал студаки забирать."));
        trenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));
        trenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));
        trenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));
        trenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));
        trenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));
        trenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));

        RecyclerView = root.findViewById(R.id.treners_recycler);
        RecyclerView.setHasFixedSize(true);
        LayoutManager = new LinearLayoutManager(getContext());
        Adapter = new TrenersAdapter(MainActivity.getInstance().getTreners());

        RecyclerView.setLayoutManager(LayoutManager);
        RecyclerView.setAdapter(Adapter);


        return root;
    }

    public void update(){
        MainActivity.getInstance().getTreners();
    }
}
