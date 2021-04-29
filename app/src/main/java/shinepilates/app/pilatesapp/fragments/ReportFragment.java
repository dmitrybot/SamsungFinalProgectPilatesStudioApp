package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.adapters.ReportAdapter;
import shinepilates.app.pilatesapp.objects.Report;

public class ReportFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root2 = inflater.inflate(R.layout.activity_main, container, false);
        View root = inflater.inflate(R.layout.fragment_report, container, false);
        ArrayList<Report> reports = new ArrayList<>();
        reports.add(new Report("name1", "date1", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 1"));
        reports.add(new Report("name2", "date2", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 2"));
        reports.add(new Report("name3", "date3", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 3"));
        reports.add(new Report("name4", "date4", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 4"));
        reports.add(new Report("name5", "date5", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 5"));

        recyclerView = root.findViewById(R.id.recyclerview);
        //View drawer = root2.findViewById(R.id.drawer_layout);
        //drawer.setDrawerLockMode(drawer.LOCK_MODE_LOCKED_CLOSED);
        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new ReportAdapter(reports);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return root;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_report, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
