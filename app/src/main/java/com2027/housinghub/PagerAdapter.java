package com2027.housinghub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int noOfTabs;

    public PagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.noOfTabs = tabCount;
    }

    @Override
    public Fragment getItem (int position) {
        switch (position) {
            case 0:
                GroupFragment tab1 = new GroupFragment();
                return tab1;
            case 1:
                FavouritesFragment tab2 = new FavouritesFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.noOfTabs;
    }


}
