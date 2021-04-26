package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.TrenersItem;
import shinepilates.app.pilatesapp.adapters.NewsAdapter;
import shinepilates.app.pilatesapp.adapters.TrenersAdapter;
import shinepilates.app.pilatesapp.objects.NewsItem;

public class NewsFragment extends Fragment {
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager LayoutManager;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news, container, false);

        ArrayList<NewsItem> newsList  = new ArrayList<>();
        newsList.add( new NewsItem(R.drawable.ic_android_test, "date1", "tag", "main_text"));
        newsList.add( new NewsItem(0, "date2", "tag", "main_text"));
        newsList.add( new NewsItem(R.drawable.ic_android_test, "date3", "tag", "main_text"));
        newsList.add( new NewsItem(0, "date4", "tag", "main_text"));
        newsList.add( new NewsItem(R.drawable.ic_android_test, "date5", "tag", "main_text"));
        newsList.add( new NewsItem(R.drawable.ic_android_test, "date6", "tag", "main_text"));
        newsList.add( new NewsItem(R.drawable.ic_android_test, "date7", "tag", "main_text"));

        RecyclerView = root.findViewById(R.id.news_recycler);
        RecyclerView.setHasFixedSize(true);
        LayoutManager = new LinearLayoutManager(getContext());
        Adapter = new NewsAdapter(newsList);

        RecyclerView.setLayoutManager(LayoutManager);
        RecyclerView.setAdapter(Adapter);

        return root;
    }
}
