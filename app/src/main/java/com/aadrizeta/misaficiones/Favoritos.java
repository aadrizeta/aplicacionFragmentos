package com.aadrizeta.misaficiones;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.aadrizeta.misaficiones.databinding.ActivityFavoritosBinding;
import com.aadrizeta.misaficiones.ui.fragmentManager.PaginadorFavoritos;

import androidx.appcompat.app.AppCompatActivity;

public class Favoritos extends AppCompatActivity {

    private ActivityFavoritosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFavoritosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PaginadorFavoritos paginador = new PaginadorFavoritos(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPagerFavoritos;
        viewPager.setAdapter(paginador);
    }
}
