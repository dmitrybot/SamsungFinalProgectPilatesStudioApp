package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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
        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new ReportAdapter(reports);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return root;
    }
}
