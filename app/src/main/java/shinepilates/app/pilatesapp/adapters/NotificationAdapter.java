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
import shinepilates.app.pilatesapp.objects.NewsItem;
import shinepilates.app.pilatesapp.objects.Notification;
import shinepilates.app.pilatesapp.objects.Report;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private ArrayList<Notification> notifications;
    public static class NotificationViewHolder extends RecyclerView.ViewHolder{
        public TextView date, mainText;
        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            mainText = itemView.findViewById(R.id.main_text);
        }
    }

    public NotificationAdapter(ArrayList<Notification> notifications){
        this.notifications = notifications;
    }

    public ArrayList<Notification> getNotificationList(){
        notifications = (ArrayList) MainActivity.getInstance().getUser().getNotifications();
        return notifications;
    }

    public void setNotificationList(ArrayList<Notification> notifications){
        this.notifications = notifications;
    }

    @Override
    public NotificationAdapter.NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        NotificationAdapter.NotificationViewHolder nh = new NotificationAdapter.NotificationViewHolder(v);
        return nh;
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.NotificationViewHolder holder, int position) {
        Notification currentNotification = notifications.get(position);
        holder.mainText.setText(currentNotification.getText());
        holder.date.setText(currentNotification.getDate());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }
}
