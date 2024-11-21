package com.aadrizeta.misaficiones.data;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FavoritosManager {

    private static FavoritosManager instance;
    private final List<Fragment> favoritos;

    private FavoritosManager() {
        favoritos = new ArrayList<>();
    }

    public static FavoritosManager getInstance() {
        if (instance == null) {
            instance = new FavoritosManager();
        }
        return instance;
    }

    public void addFavorito(Fragment fr) {
        if (!favoritos.contains(fr)){
            favoritos.add(fr);
        }
    }

    public List getFavoritos() {
        return favoritos;
    }
}
