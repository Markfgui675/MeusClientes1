package com.example.meusclientes1.controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.meusclientes1.datamodel.ClienteDataModel;
import com.example.meusclientes1.datasource.AppDataBase;
import com.example.meusclientes1.model.Cliente;

import java.util.List;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadosDoObjeto;

    public ClienteController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Cliente obj) {

        dadosDoObjeto = new ContentValues();

        dadosDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadosDoObjeto.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadosDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadosDoObjeto.put(ClienteDataModel.CEP, obj.getCep());
        dadosDoObjeto.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        dadosDoObjeto.put(ClienteDataModel.NUMERO, obj.getNumero());
        dadosDoObjeto.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadosDoObjeto.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadosDoObjeto.put(ClienteDataModel.ESTADO, obj.getEstado());

        return insert(ClienteDataModel.TABELA, dadosDoObjeto);

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
