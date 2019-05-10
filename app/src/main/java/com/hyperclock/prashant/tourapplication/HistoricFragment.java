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

public class HistoricFragment extends Fragment {
    public HistoricFragment() {
        //empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attration_fragment,container,false);

        final ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(getString(R.string.attraction_1),getString(R.string.attraction_desc_1),14.235430,74.440579));
        attractions.add(new Attraction(getString(R.string.attraction_2),getString(R.string.attraction_desc_2),14.285466,74.450541));
        attractions.add(new Attraction(getString(R.string.attraction_3),getString(R.string.attraction_desc_3),14.309210,74.426815));
        attractions.add(new Attraction(getString(R.string.attraction_4),getString(R.string.attraction_desc_4),14.276222, 74.441258));

        RestaurantAdapter attractionsAdapter = new RestaurantAdapter(getContext(),attractions,R.color.colorAccent1);

        ListView listView = rootView.findViewById(R.id.listview_attraction);
        listView.setAdapter(attractionsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Attraction currentRestaurant = attractions.get(i);
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
