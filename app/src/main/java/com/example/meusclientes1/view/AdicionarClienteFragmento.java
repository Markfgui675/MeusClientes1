package com.example.meusclientes1.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.meusclientes1.R;
import com.example.meusclientes1.controller.ClienteController;
import com.example.meusclientes1.model.Cliente;

public class AdicionarClienteFragmento extends Fragment {

    View view;

    TextView txtTitulo;
    EditText nome, telefone, email, cep, logradouro, numero, bairro, cidade, estado;
    CheckBox termos;
    Button cancelar, salvar;

    Cliente novoCliente;
    ClienteController clienteController;

    public AdicionarClienteFragmento(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        //initComponents();

        //eventsButtons();

        return inflater.inflate(R.layout.fragmente_adicionar_cliente, container, false);
    }

    /**
     * Eventos executados pelos botões
     */
    private void eventsButtons() {

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOK = true;



                if(isDadosOK){
                    clienteController.incluir(novoCliente);
                } else {

                }

            }
        });

    }

    /**
     * Inicializar os componentes da tela para adicionar os clientes
     */
    private void initComponents() {

        nome = view.findViewById(R.id.editNomeCompleto);
        telefone = view.findViewById(R.id.editTelefone);
        email = view.findViewById(R.id.editEmail);
        cep = view.findViewById(R.id.editCep);
        logradouro = view.findViewById(R.id.editLogradouro);
        numero = view.findViewById(R.id.editNumero);
        bairro = view.findViewById(R.id.editBairro);
        cidade = view.findViewById(R.id.editCidade);
        estado = view.findViewById(R.id.editEstado);

        termos = view.findViewById(R.id.termos);

        cancelar = view.findViewById(R.id.btnCancelar);
        salvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getContext());

    }
}
