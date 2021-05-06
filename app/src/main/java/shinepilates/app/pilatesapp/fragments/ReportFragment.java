package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
<<<<<<< Updated upstream
=======
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
>>>>>>> Stashed changes
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
<<<<<<< Updated upstream
=======
import shinepilates.app.pilatesapp.TrenersItem;
import shinepilates.app.pilatesapp.User;
import shinepilates.app.pilatesapp.adapters.NewsAdapter;
>>>>>>> Stashed changes
import shinepilates.app.pilatesapp.adapters.ReportAdapter;
import shinepilates.app.pilatesapp.objects.Report;

public class ReportFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefresh;
    ArrayList<Report> reports = new ArrayList<>();
    User user;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_report, container, false);
        setHasOptionsMenu(true);
        recyclerView = root.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new ReportAdapter(MainActivity.getInstance().getReports());
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

                    ((ReportAdapter) recyclerView.getAdapter()).getReportList().remove(viewHolder.getAdapterPosition());
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        };

        if (MainActivity.getInstance().getUser().getRole() == 2){
            new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView);
        }

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                swipeRefresh.setRefreshing(false);
            }
        });


        return root;
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        if ((MainActivity.getInstance().getUser().getRole() == 1)){
            inflater.inflate(R.menu.menu_report, menu);
            super.onCreateOptionsMenu(menu, inflater);
        }
    }

    /*public void update (){
        adapter = new ReportAdapter(MainActivity.getInstance().getReports());
    }*/



    /*public void Addclick (MenuItem item){
        MainActivity.getInstance().goToFragment(R.id.nav_addreport);
    }*/
}
