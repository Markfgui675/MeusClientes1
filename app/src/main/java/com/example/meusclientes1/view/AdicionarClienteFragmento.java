package com.example.meusclientes1.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.meusclientes1.R;

public class AdicionarClienteFragmento extends Fragment {

    View view;

    public AdicionarClienteFragmento(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragmente_adicionar_cliente, container, false);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);

        txtTitulo.setText("Cliente VIP DEMO");

        txtTitulo.setTextColor(ColorStateList.valueOf(Color.CYAN));

        return view;

    }

}
