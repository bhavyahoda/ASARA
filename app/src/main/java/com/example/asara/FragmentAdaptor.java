package com.example.asara;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class FragmentAdaptor extends FragmentPagerAdapter {
    public FragmentAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new ActiveCasesFragment();
            case 1: return new ResolvedCasesFragment();
            default: return new ActiveCasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;       //total no. of fragments, we have 3
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if(position == 0) {
            title = "Active Cases";
        }
        else if(position == 1) {
            title = "Resolved cases";
        }
        return title;
    }
}
