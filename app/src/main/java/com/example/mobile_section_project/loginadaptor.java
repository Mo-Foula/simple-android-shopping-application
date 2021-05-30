package com.example.mobile_section_project;

import android.content.Context;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class loginadaptor extends FragmentPagerAdapter{
    private Context context;
    int totaltabs;

    public loginadaptor(FragmentManager fm, Context context, int totaltabs){
        super(fm);
        this.context=context;
        this.totaltabs=totaltabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                logintab logintab=new logintab();
                return logintab;
            case 1:
                signuptab signuptab=new signuptab();
                return signuptab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totaltabs;
    }


}
