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

public class LandmarkFragment extends Fragment {
    public LandmarkFragment() {
        //empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.landmark_fragment,container,false);

        final ArrayList<Landmark> landmarks = new ArrayList<>();

        landmarks.add(new Landmark(14.281429, 74.450699,getString(R.string.landmark_1), getString(R.string.landmark_desc_1),R.drawable.prathibodaya));
        landmarks.add(new Landmark(14.281429, 74.450699,getString(R.string.landmark_2), getString(R.string.landmark_desc_2),R.drawable.light_house));

        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(getContext(),landmarks,R.color.colorAccent2);

        ListView listView = rootView.findViewById(R.id.listview_landmark);
        listView.setAdapter(landmarkAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Landmark currentLandmark = landmarks.get(position);
                Toast.makeText(getContext(), getString(R.string.getLocation)+currentLandmark.getName(), Toast.LENGTH_SHORT).show();
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+currentLandmark.getLat()+",+"+currentLandmark.getLon()+"+");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage(getString(R.string.googleMaps));
                startActivity(mapIntent);
            }
        });
        return rootView;
    }
}
