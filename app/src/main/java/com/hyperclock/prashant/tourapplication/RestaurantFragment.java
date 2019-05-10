package com.hyperclock.prashant.tourapplication;

import android.annotation.SuppressLint;
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

@SuppressLint("ValidFragment")
class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
        //empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.restaurant_fragment,container,false);

        final ArrayList<Attraction> restaurantList = new ArrayList<>();

        restaurantList.add(new Attraction(getString(R.string.restaurant_1), getString(R.string.restaurant_desc_1),14.290767,74.462474 ));
        restaurantList.add(new Attraction(getString(R.string.restaurant_2), getString(R.string.restaurant_desc_2),14.279875,74.448408));
        restaurantList.add(new Attraction(getString(R.string.restaurant_3), getString(R.string.restaurant_desc_3),14.275856,74.443427));
        restaurantList.add(new Attraction(getString(R.string.restaurant_4), getString(R.string.restaurant_desc_4),14.283163,74.451736));

        ListView listView = rootView.findViewById(R.id.listview_restaurant);
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(getContext(),restaurantList,R.color.colorAccent3);
        listView.setAdapter(restaurantAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Attraction currentRestaurant = restaurantList.get(i);
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
