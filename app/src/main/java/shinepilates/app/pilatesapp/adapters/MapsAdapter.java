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
import shinepilates.app.pilatesapp.objects.MapItem;



public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.MapsViewHolder> {
    private ArrayList<MapItem> mapList;
    private OnItemClickListener mListener;
    private int position;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }




    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class MapsViewHolder extends RecyclerView.ViewHolder{
        public ImageView StudioImage;
        public TextView StudioName;
        public TextView description;
        public View Card;


        public MapsViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            StudioImage = itemView.findViewById(R.id.map_imageView);
            StudioName = itemView.findViewById(R.id.studio_name);
            description = itemView.findViewById(R.id.studio_location);
            Card = itemView.findViewById(R.id.card_view);
            Card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        System.out.println("dfbdhfjdbfdhfdjndbdghsfhffjfgggjjjj");
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }


    public MapsAdapter (ArrayList<MapItem> mapList, OnItemClickListener listener){
        this.mapList = mapList;
        mListener = listener;
    }

    /*public ArrayList<MapItem> getMapList(){
        mapList = MainActivity.getInstance().getNews();
        return mapList;
    }*/



    @NonNull
    @Override
    public MapsAdapter.MapsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.maps_item, parent, false);
        MapsAdapter.MapsViewHolder mh = new MapsAdapter.MapsViewHolder(v, mListener);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull MapsAdapter.MapsViewHolder holder, int position) {
        MapItem currentItem = mapList.get(position);
        holder.StudioName.setText(currentItem.getStudioName());
        holder.description.setText(currentItem.getStudioDescription());
        holder.StudioImage.setImageResource(currentItem.getStudioImage());
    }



    @Override
    public int getItemCount() {
        return mapList.size();
    }
}
