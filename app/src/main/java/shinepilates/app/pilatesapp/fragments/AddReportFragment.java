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
import shinepilates.app.pilatesapp.objects.Report;
import shinepilates.app.pilatesapp.objects.User;

public class AddReportFragment extends Fragment {
    EditText addReport;
    Button add;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_report, container, false);
        addReport = root.findViewById(R.id.addReport);
        add = root.findViewById(R.id.addRep);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text = String.valueOf(addReport.getText());
                Report report = new Report();
                report.setMaintext(Text);
                User user = MainActivity.getInstance().getUser();
                report.setName(user.getFirstName());
                long epoch = System.currentTimeMillis() / 1000;
                String date = new java.text.SimpleDateFormat("dd.MM.yyyy").format(new java.util.Date(epoch * 1000));
                report.setDate(date);
                MainActivity.getInstance().addReport(report);
            }
        });
        return root;
    }
}
