package shinepilates.app.pilatesapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.adapters.MapsAdapter;
import shinepilates.app.pilatesapp.objects.MapItem;

public class MapsFragment extends Fragment{
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    private MapsAdapter Adapter;
    private RecyclerView.LayoutManager LayoutManager;
    ArrayList<MapItem> mapItem = new ArrayList<>();
    GoogleMap map;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_maps, container, false);
        RecyclerView = root.findViewById(R.id.maps_recycler);
        RecyclerView.setHasFixedSize(true);
        setHasOptionsMenu(true);
        LayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.setLayoutManager(LayoutManager);
        MapsAdapter.OnItemClickListener onItemClickListener = new MapsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                System.out.println("12235672462642882658358378537");
                if (position == 0){
                    String mapLabel = "ABC";
                    //Uri mapUri = Uri.parse("geo:0,0?q=55.68002,37.48768(" + mapLabel + ")");
                    Uri mapUri = Uri.parse("google.navigation:q=55.68002,37.48768");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                } else if (position == 1){
                    Uri mapUri = Uri.parse("google.navigation:q=55.67910,37.48595");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }
            }
        };
        Adapter = new MapsAdapter(MainActivity.getInstance().getMap(), onItemClickListener);
        RecyclerView.setAdapter(Adapter);
        mapItem = MainActivity.getInstance().getMap();
        /*Adapter.setOnItemClickListener(new MapsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (position == 0){
                    Uri mapUri = Uri.parse("geo:55.68002,37.48768");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }
            }
        });*/

        //SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.maps);
        /*mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                LatLng sydney = new LatLng(55, 37);
                map.addMarker(new MarkerOptions().position(sydney).title("Marker in Moscow"));
                map.moveCamera(CameraUpdateFactory.newLatLng(sydney));



                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latLng);
                        markerOptions.title(latLng.latitude + " : " + latLng.longitude);
                        googleMap.clear();
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                        googleMap.addMarker(markerOptions);

                    }
                });
            }
        });*/

        return root;

    }



}