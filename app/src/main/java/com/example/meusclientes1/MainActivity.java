package com.example.meusclientes1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Gerenciamente dos fragmentos
    FragmentManager fragmentManager;

    // Gerenciamento do menu drawer
    NavigationView navigationView;

    // Gereciamento do menu action bar
    Menu menu;

    // Gerenciamento de cada item do menu drawer
    MenuItem nav_preto;
    MenuItem nav_vermelho;
    MenuItem nav_azul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }

}