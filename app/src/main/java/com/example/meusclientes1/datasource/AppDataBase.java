package com.example.meusclientes1.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.meusclientes1.api.AppUtil;
import com.example.meusclientes1.datamodel.ClienteDataModel;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "MeusClientes.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClienteDataModel.criarTabela());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(String tabela, ContentValues dados){
        db = getWritableDatabase();

        boolean retorno = false;

        try{
            retorno = db.insert(tabela, null, dados) > 0;

        } catch (Exception e){
            Log.d(AppUtil.TAG, "insert: "+e.getMessage());
            //Toast.makeText(, "Não foi possível cadastrar o cliente.", Toast.LENGTH_SHORT).show();
        }

        return retorno;
    }

}
