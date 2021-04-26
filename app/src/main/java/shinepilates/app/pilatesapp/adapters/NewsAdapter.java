package shinepilates.app.pilatesapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.TrenersItem;
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
        if (currentItem.getImageNews() != 0){
            holder.imageView.setImageResource(currentItem.getImageNews());
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