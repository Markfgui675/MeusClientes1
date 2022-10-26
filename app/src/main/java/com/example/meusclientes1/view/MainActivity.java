package com.example.meusclientes1.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.service.controls.actions.ModeAction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.meusclientes1.R;
import com.example.meusclientes1.controller.ClienteController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    ClienteController clienteController;
    private DrawerLayout drawer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ModeloAzulFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_azul);
        }

    }

    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_adicionar_cliente:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AdicionarClienteFragmento()).commit();
                break;
            case R.id.nav_preto:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ModeloPretoFragment()).commit();
                break;
            case R.id.nav_vermelho:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ModeloVermelhoFragment()).commit();
                break;
            case R.id.nav_azul:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ModeloAzulFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}