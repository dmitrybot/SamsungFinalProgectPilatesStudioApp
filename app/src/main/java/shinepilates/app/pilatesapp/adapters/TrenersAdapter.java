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
import shinepilates.app.pilatesapp.objects.TrenersItem;

public class TrenersAdapter extends RecyclerView.Adapter<TrenersAdapter.TrenersViewHolder> {
    private ArrayList<TrenersItem> mTrenersList;
    public static class TrenersViewHolder extends RecyclerView.ViewHolder{
        public ImageView TrenersImage;
        public TextView TrenersName;
        public TextView TrenersPos;
        public TextView TrenersDescr;

        public TrenersViewHolder(@NonNull View itemView) {
            super(itemView);
            TrenersImage = itemView.findViewById(R.id.trener_imageView);
            TrenersName = itemView.findViewById(R.id.trener_name);
            TrenersPos = itemView.findViewById(R.id.treners_position);
            TrenersDescr = itemView.findViewById(R.id.treners_description);
        }
    }

    public TrenersAdapter (ArrayList<TrenersItem> trenersList){
        this.mTrenersList = trenersList;
    }

    public ArrayList<TrenersItem> getTrenersList(){
        mTrenersList = MainActivity.getInstance().getTreners();
        return mTrenersList;
    }

    public void setTrenersList(List<TrenersItem> TrenersList) {
        this.mTrenersList = (ArrayList) TrenersList;
    }

    @NonNull
    @Override
    public TrenersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.treners_item, parent, false);
        TrenersViewHolder tvh = new TrenersViewHolder(v);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TrenersViewHolder holder, int position) {
        TrenersItem currentItem = mTrenersList.get(position);

        holder.TrenersImage.setImageResource(R.drawable.ic_android_test);
        holder.TrenersName.setText(currentItem.getTrenersName());
        holder.TrenersPos.setText(currentItem.getTrenersPos());
        holder.TrenersDescr.setText(currentItem.getTrenersDescr());
    }

    @Override
    public int getItemCount() {
        return mTrenersList.size();
    }
}
