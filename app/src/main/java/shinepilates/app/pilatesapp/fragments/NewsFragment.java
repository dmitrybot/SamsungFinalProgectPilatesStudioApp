package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< Updated upstream
=======
import android.widget.Adapter;
import android.widget.TextView;
>>>>>>> Stashed changes

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
<<<<<<< Updated upstream
=======
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
>>>>>>> Stashed changes
import shinepilates.app.pilatesapp.adapters.NewsAdapter;
import shinepilates.app.pilatesapp.objects.NewsItem;

public class NewsFragment extends Fragment {
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager LayoutManager;
    private SwipeRefreshLayout swipeRefresh;
    User user;
    ArrayList<NewsItem> newsList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        RecyclerView = root.findViewById(R.id.news_recycler);
        RecyclerView.setHasFixedSize(true);
        setHasOptionsMenu(true);
        LayoutManager = new LinearLayoutManager(getContext());
        Adapter = new NewsAdapter(MainActivity.getInstance().getNews());
        swipeRefresh = root.findViewById(R.id.swipeRefresh);
        RecyclerView.setLayoutManager(LayoutManager);
        RecyclerView.setAdapter(Adapter);
        newsList = MainActivity.getInstance().getNews();
        //RecyclerView.setAdapter(new NewsAdapter(getContext(), new ArrayList<>()));

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int direction) {
                if (direction == ItemTouchHelper.LEFT ) {
                    //newsList.remove(((NewsAdapter) RecyclerView.getAdapter()).getNewsList().get(viewHolder.getAdapterPosition()));

                    ((NewsAdapter) RecyclerView.getAdapter()).getNewsList().remove(viewHolder.getAdapterPosition());
                    RecyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        };

        if (MainActivity.getInstance().getUser().getRole() == 2){
            new ItemTouchHelper(simpleCallback).attachToRecyclerView(RecyclerView);
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
        if ((MainActivity.getInstance().getUser().getRole() == 2)){
            inflater.inflate(R.menu.menu_news, menu);
            super.onCreateOptionsMenu(menu, inflater);
        }
    }



    /*public void deleteNews(Long id){
        for (newsList employee: employees){
            if (employee.getId() == id){
                employees.remove(employee);
            }
        }
    }*/

    /*public ArrayList<NewsItem> getNewsList(){
            return newsList;
    }*/

}
