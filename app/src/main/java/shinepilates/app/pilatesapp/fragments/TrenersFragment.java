package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.util.Log;
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

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.adapters.TrenersAdapter;
import shinepilates.app.pilatesapp.objects.TrenersItem;
import shinepilates.app.pilatesapp.objects.User;

public class TrenersFragment extends Fragment {
    private RecyclerView RecyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager LayoutManager;
    private SwipeRefreshLayout swipeRefresh;
    ArrayList<TrenersItem> treners = new ArrayList<>();
    TrenersItem trener;
    User user;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_treners, container, false);

        RecyclerView = root.findViewById(R.id.treners_recycler);
        RecyclerView.setHasFixedSize(true);
        setHasOptionsMenu(true);
        LayoutManager = new LinearLayoutManager(getContext());
        Adapter = new TrenersAdapter(MainActivity.getInstance().getTreners());
        swipeRefresh = root.findViewById(R.id.swipeRefresh);
        RecyclerView.setLayoutManager(LayoutManager);
        RecyclerView.setAdapter(Adapter);
        treners = MainActivity.getInstance().getTreners();
        Log.d("sdfgbhnhgfdsdfghnjfd", "dfgfbfdedwqedefrgftdesgnmjfdesesghfngdedgrhfngmfrdgfnhgfbfvg");
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int direction) {
                if (direction == ItemTouchHelper.LEFT ) {
                    //newsList.remove(((NewsAdapter) RecyclerView.getAdapter()).getNewsList().get(viewHolder.getAdapterPosition()));

                    trener = ((TrenersAdapter) RecyclerView.getAdapter()).getTrenersList().get(viewHolder.getAdapterPosition());
                    MainActivity.getInstance().deleteTrener(trener);
                }
            }
        };
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(RecyclerView);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                MainActivity.getInstance().addTreners();
                treners = MainActivity.getInstance().getTreners();
                ((TrenersAdapter) RecyclerView.getAdapter()).setTrenersList(treners);
                RecyclerView.getAdapter().notifyDataSetChanged();
                swipeRefresh.setRefreshing(false);
            }
        });

        return root;
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_treners, menu);
        super.onCreateOptionsMenu(menu, inflater);
        /*if ((MainActivity.getInstance().getUser().getRole() == 2)){
            inflater.inflate(R.menu.menu_treners, menu);
            super.onCreateOptionsMenu(menu, inflater);
        }*/
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.addTrener:
                MainActivity.getInstance().goToFragment(R.id.nav_addTrener);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*public void update(){
        MainActivity.getInstance().getTreners();
    }*/
}
