package com.hyperclock.prashant.tourapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LandmarkAdapter extends ArrayAdapter<Landmark> {

    private int backgroundColor;

    public LandmarkAdapter(@NonNull Context context, ArrayList<Landmark> landmarks, int backgroundColor) {
        super(context, 0,landmarks);
        this.backgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View rootView, @NonNull ViewGroup parent) {
        if(rootView == null){
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.landmark_list_item,parent,false);
        }

        Landmark currentLandmark = getItem(position);
        TextView name = rootView.findViewById(R.id.landmark_name_tv);
        TextView desc = rootView.findViewById(R.id.landrmark_desc_tv);
        ImageView image = rootView.findViewById(R.id.landmark_iv);

        name.setText(currentLandmark.getName());
        desc.setText(currentLandmark.getDesc());
        image.setImageResource(currentLandmark.getImageId());

        int color = ContextCompat.getColor(getContext(), backgroundColor);
        name.setBackgroundColor(color);

        return rootView;
    }
}
