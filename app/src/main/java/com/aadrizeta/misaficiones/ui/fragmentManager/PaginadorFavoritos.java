package com.aadrizeta.misaficiones.ui.fragmentManager;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.aadrizeta.misaficiones.data.FavoritosManager;

import java.util.List;

public class PaginadorFavoritos extends FragmentPagerAdapter {

    private final Context mContext;

    public PaginadorFavoritos(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // Obtener la lista de favoritos y devolver el fragmento correspondiente
        List<Fragment> favoritos = FavoritosManager.getInstance().getFavoritos();
        return favoritos.get(position);
    }

    @Override
    public int getCount() {
        // Devolver el número total de favoritos
        return FavoritosManager.getInstance().getFavoritos().size();
    }
}

