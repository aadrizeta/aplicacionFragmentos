package com.aadrizeta.misaficiones;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.aadrizeta.misaficiones.data.FavoritosManager;
import com.aadrizeta.misaficiones.databinding.ActivityAficionesBinding;
import com.aadrizeta.misaficiones.ui.fragmentManager.PaginadorAficiones;
import com.aadrizeta.misaficiones.ui.fragmentManager.PaginadorFavoritos;

import java.util.ArrayList;
import java.util.List;

public class Aficiones extends AppCompatActivity {

    private ActivityAficionesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAficionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PaginadorAficiones paginador = new PaginadorAficiones(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.addFavButton){
            ViewPager viewPager = binding.viewPager;
            int currentItem = viewPager.getCurrentItem();
            //Cambiar el icono del botón
            item.setIcon(R.drawable.baseline_star_24);

            PaginadorAficiones paginador = (PaginadorAficiones) viewPager.getAdapter();
            if (paginador != null){
                Fragment frActual = paginador.getItem(currentItem);
                FavoritosManager.getInstance().addFavorito(frActual);
                Toast.makeText(this, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
            }
        }
        if (id == R.id.showFavButton){
            Intent intent = new Intent(this, Favoritos.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}