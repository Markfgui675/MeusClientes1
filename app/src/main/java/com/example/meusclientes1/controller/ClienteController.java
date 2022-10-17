package com.example.meusclientes1.controller;

import android.content.Context;

import com.example.meusclientes1.datasource.AppDataBase;
import com.example.meusclientes1.model.Cliente;

import java.util.List;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {


    public ClienteController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Cliente obj) {
        return false;
    }

    @Override
    public boolean alterar(Cliente obj) {
        return false;
    }

    @Override
    public boolean deletar(int id) {
        return false;
    }

    @Override
    public List<Cliente> listar() {
        return null;
    }
}
