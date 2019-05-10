package com.hyperclock.prashant.tourapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TempleFragment extends Fragment {
    public TempleFragment() {
        //empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.temple_fragment,container,false);

        final ArrayList<Attraction> temples = new ArrayList<>();

        temples.add(new Attraction(getString(R.string.temple1),getString(R.string.temple_desc_1),14.284845, 74.453191));
        temples.add(new Attraction(getString(R.string.temple2),getString(R.string.temple_desc_2),14.276301, 74.442347
        ));
        temples.add(new Attraction(getString(R.string.temple3),getString(R.string.temple_desc_3),14.284287, 74.446404
        ));
        temples.add(new Attraction(getString(R.string.temple4),getString(R.string.temple_desc_4),14.280015, 74.443428
        ));

        RestaurantAdapter templesAdapter = new RestaurantAdapter(getContext(),temples,R.color.colorAccent4);
        ListView listView = rootView.findViewById(R.id.listview_temple);

        listView.setAdapter(templesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Attraction currentRestaurant = temples.get(i);
                Toast.makeText(getContext(), getString(R.string.getLocation)+currentRestaurant.getName(), Toast.LENGTH_SHORT).show();
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+currentRestaurant.getLattitude()+",+"+currentRestaurant.getLongitude()+"+");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage(getString(R.string.googleMaps));
                startActivity(mapIntent);
            }
        });
        return rootView;
    }
}
