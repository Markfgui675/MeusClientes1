package com.example.meusclientes1.view;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.meusclientes1.R;
import com.example.meusclientes1.controller.ClienteController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, onOptionItemSelected {

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

    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

               // Snackbar.make(view, "Action Button Clicado", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Toast.makeText(MainActivity.this, "Action Butto clicado", Toast.LENGTH_LONG).show();

            }
        });

        // drawer_layout é o layout padrão do aplicativo
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // nav_view contém o layout do menu
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloVermelhoFragment()).commit();

        clienteController = new ClienteController(getApplicationContext());

    }

    @Override
    public void onBackPressed(){
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.nav_preto){

            menu = navigationView.getMenu();

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto ativado");

            nav_vermelho = menu.findItem(R.id.nav_vermelho);
            nav_vermelho.setTitle("Vermelho");

            nav_azul = menu.findItem(R.id.nav_azul);
            nav_azul.setTitle("Azul");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloPretoFragment()).commit();

        } else if(id == R.id.nav_vermelho) {

            menu = navigationView.getMenu();

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto");

            nav_vermelho = menu.findItem(R.id.nav_vermelho);
            nav_vermelho.setTitle("Vermelho ativo");

            nav_azul = menu.findItem(R.id.nav_azul);
            nav_azul.setTitle("Azul");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloPretoFragment()).commit();

        } else if(id == R.id.nav_azul){

            menu = navigationView.getMenu();

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto");

            nav_vermelho = menu.findItem(R.id.nav_vermelho);
            nav_vermelho.setTitle("Vermelho");

            nav_azul = menu.findItem(R.id.nav_azul);
            nav_azul.setTitle("Azul Ativado");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloAzulFragment()).commit();

        } else if (id == R.id.nav_adicionar_cliente){

            setTitle("Novo Cliente");

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new AdicionarClienteFragmento()).commit();

            return true;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}