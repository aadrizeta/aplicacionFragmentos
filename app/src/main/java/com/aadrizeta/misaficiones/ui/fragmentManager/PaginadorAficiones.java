package com.aadrizeta.misaficiones.ui.fragmentManager;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.aadrizeta.misaficiones.fr.aficiones.Comer;
import com.aadrizeta.misaficiones.fr.aficiones.Dormir;


public class PaginadorAficiones extends FragmentPagerAdapter {

    private final Context mContext;

    public PaginadorAficiones(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Comer();
            case 1:
                return new Dormir();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
