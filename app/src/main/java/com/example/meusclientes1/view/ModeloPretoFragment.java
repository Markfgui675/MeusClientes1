package com.example.meusclientes1.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.meusclientes1.R;

public class ModeloPretoFragment extends Fragment {

    View view;

    public ModeloPretoFragment() {

    }

    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_preto, container, false);
        TextView txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.modelo_fragment);
        txtTitulo.setTextColor(ColorStateList.valueOf(Color.CYAN));
        return view;
    }

}
