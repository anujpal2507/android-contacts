package com.example.anujpal.contacts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;

/**
 * Created by anujpal on 4/12/15.
 */
public class PageAdapter extends FragmentStatePagerAdapter {

    int mNumofTabs;

    public PageAdapter(FragmentManager fm,int NumofTabs){
        super(fm);
        this.mNumofTabs=NumofTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FavoritesFragment tabfav = new FavoritesFragment();
                return tabfav;
            case 1:
                PhoneFragment tabphn = new PhoneFragment();
                return tabphn;
            case 2:
                ContactFragment tabcontact = new ContactFragment();
                return tabcontact;
            case 3:
                GroupFragment tabgrp = new GroupFragment();
                return tabgrp;
            default:
                PhoneFragment tabphn1 = new PhoneFragment();
                return tabphn1;
        }
    }

    @Override
    public int getCount() {
        return mNumofTabs;
    }
}
