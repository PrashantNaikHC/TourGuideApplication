package com.hyperclock.prashant.tourapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantAdapter extends ArrayAdapter<Attraction> {

    private int backgroundColor;

    public RestaurantAdapter(@NonNull Context context, ArrayList<Attraction> restaurants, int backgroundColor) {
        super(context, 0, restaurants);
        this.backgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View rootView, @NonNull ViewGroup parent) {
        if(rootView == null){
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.restaurant_list_item,parent, false);
        }

        Attraction currentRestaurant = getItem(position);

        TextView name = rootView.findViewById(R.id.name_tv);
        TextView description = rootView.findViewById(R.id.description_tv);

        name.setText(currentRestaurant.getName());
        description.setText(currentRestaurant.getDescription());

        int color = ContextCompat.getColor(getContext(), backgroundColor);
        name.setBackgroundColor(color);

        return rootView;
    }
}
