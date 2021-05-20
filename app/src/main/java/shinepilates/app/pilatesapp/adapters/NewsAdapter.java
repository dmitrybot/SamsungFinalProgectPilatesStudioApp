package shinepilates.app.pilatesapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.objects.NewsItem;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private ArrayList<NewsItem> newsList;
    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView date;
        public TextView tag;
        public TextView main_text;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            date = itemView.findViewById(R.id.date);
            tag = itemView.findViewById(R.id.tag);
            main_text = itemView.findViewById(R.id.main_text);
        }
    }


    public NewsAdapter (ArrayList<NewsItem> newsList){
        this.newsList = newsList;
    }

    public void setNewsList(List<NewsItem> NewsList) {
        this.newsList = (ArrayList) NewsList;
    }

    public ArrayList<NewsItem> getNewsList(){
        newsList = MainActivity.getInstance().getNews();
        return newsList;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        NewsAdapter.NewsViewHolder nh = new NewsAdapter.NewsViewHolder(v);
        return nh;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        NewsItem currentItem = newsList.get(position);
        if (position % 2 == 0){
            holder.imageView.setImageResource(R.drawable.ic_android_test);
        } else {
            holder.imageView.setVisibility(View.GONE);
        }
        holder.date.setText(currentItem.getDate());
        holder.tag.setText(currentItem.getTag());
        holder.main_text.setText(currentItem.getMain_text());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}