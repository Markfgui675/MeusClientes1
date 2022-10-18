package com.example.meusclientes1.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.meusclientes1.R;
import com.example.meusclientes1.controller.ClienteController;
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

    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteController = new ClienteController(getApplicationContext());

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.nav_preto){

            menu = navigationView.getMenu();

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto");

            nav_vermelho = menu.findItem(R.id.nav_vermelho);
            nav_vermelho.setTitle("Vermelho");

            nav_azul = menu.findItem(R.id.nav_azul);
            nav_azul.setTitle("Azul ativado");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloPretoFragment()).commit();

        } else if (id == R.id.nav_adicionar_cliente){

            setTitle("Novo Cliente");

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new AdicionarClienteFragmento()).commit();

            return true;

        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}