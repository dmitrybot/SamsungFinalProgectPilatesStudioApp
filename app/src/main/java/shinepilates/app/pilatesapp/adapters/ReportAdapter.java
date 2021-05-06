package shinepilates.app.pilatesapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.objects.Notification;
import shinepilates.app.pilatesapp.objects.Report;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {

    private ArrayList<Report> reports;
    public static class ReportViewHolder extends RecyclerView.ViewHolder{
        public TextView name, date, mainText;
        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            mainText = itemView.findViewById(R.id.main_text);
        }
    }

    public ReportAdapter(ArrayList<Report> reports){
        this.reports = reports;
    }

    public ArrayList<Report> getReportList(){
        reports = MainActivity.getInstance().getReports();
        return reports;
    }

    @Override
    public ReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_item, parent, false);
        ReportViewHolder rh = new ReportViewHolder(v);
        return rh;
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        Report currentReport = reports.get(position);
        holder.mainText.setText(currentReport.getText());
        holder.date.setText(currentReport.getDate());
        holder.name.setText(currentReport.getName());
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }
}
