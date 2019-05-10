package com.hyperclock.prashant.tourapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private final Context context;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RestaurantFragment();
            case 1:
                return new LandmarkFragment();
            case 2:
                return new HistoricFragment();
            case 3:
                return new TempleFragment();
            default:
                return new TempleFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.restaurants);
            case 1:
                return context.getString(R.string.landmarks);
            case 2:
                return context.getString(R.string.attractions);
            case 3:
                return context.getString(R.string.temples);
            default:
                return context.getString(R.string.temples);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
