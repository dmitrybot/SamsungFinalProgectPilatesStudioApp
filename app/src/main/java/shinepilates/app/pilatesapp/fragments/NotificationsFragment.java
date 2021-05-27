package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.adapters.NotificationAdapter;
import shinepilates.app.pilatesapp.adapters.ReportAdapter;
import shinepilates.app.pilatesapp.objects.Notification;
import shinepilates.app.pilatesapp.objects.User;

public class NotificationsFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefresh;
    User user;
    ArrayList<Notification> notifications = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        recyclerView = root.findViewById(R.id.recyclerview);
        user = MainActivity.getInstance().getUser();
        layoutManager = new LinearLayoutManager(getContext());
        if (user.getNotifications() != null){
            notifications = (ArrayList) user.getNotifications();
        }
        adapter = new NotificationAdapter(notifications);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        swipeRefresh = root.findViewById(R.id.swipeRefresh);
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int direction) {
                if (direction == ItemTouchHelper.LEFT ) {
                    //newsList.remove(((NewsAdapter) RecyclerView.getAdapter()).getNewsList().get(viewHolder.getAdapterPosition()));
                    Notification notification = ((NotificationAdapter) recyclerView.getAdapter()).getNotificationList().get(viewHolder.getAdapterPosition());
                    MainActivity.getInstance().deleteNotification(notification);
                }
            }
        };
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView);

        /*if (MainActivity.getInstance().getUser().getRole() == 2){
            new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView);
        }*/

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (user.getPhone() != null){
                    MainActivity.getInstance().updateNotifications();
                    notifications = (ArrayList) MainActivity.getInstance().getUser().getNotifications();
                    ((NotificationAdapter) recyclerView.getAdapter()).setNotificationList(notifications);
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
                swipeRefresh.setRefreshing(false);
            }
        });

        return root;
    }

    /*public void update (){
        MainActivity.getInstance().getNotifications();
    }*/

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_notifications, menu);
        super.onCreateOptionsMenu(menu, inflater);
        /*if ((MainActivity.getInstance().getUser().getRole() == 2)){
            inflater.inflate(R.menu.menu_notifications, menu);
            super.onCreateOptionsMenu(menu, inflater);
        }*/
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.addNot:
                MainActivity.getInstance().goToFragment(R.id.nav_addNotification);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }





}
