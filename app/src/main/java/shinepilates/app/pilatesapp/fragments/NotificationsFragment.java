package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.adapters.NotificationAdapter;
import shinepilates.app.pilatesapp.adapters.ReportAdapter;
import shinepilates.app.pilatesapp.objects.Notification;
import shinepilates.app.pilatesapp.objects.Report;

public class NotificationsFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        ArrayList<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification( "date1", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 1"));
        notifications.add(new Notification("date2", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 2"));
        notifications.add(new Notification("date3", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 3"));
        notifications.add(new Notification("date4", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 4"));
        notifications.add(new Notification("date5", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 5"));

        recyclerView = root.findViewById(R.id.recyclerview);
        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new NotificationAdapter(notifications);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return root;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_notifications, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }



}
