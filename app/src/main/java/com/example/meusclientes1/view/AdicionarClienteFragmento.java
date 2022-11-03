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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.meusclientes1.R;
import com.example.meusclientes1.controller.ClienteController;
import com.example.meusclientes1.model.Cliente;

public class AdicionarClienteFragmento extends Fragment{

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        initComponents();

        eventsButtons();

        return inflater.inflate(R.layout.fragmente_adicionar_cliente, container, false);
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

    /**
     * Eventos executados pelos botões
     */
    private void eventsButtons() {

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOK = true;

                if(TextUtils.isEmpty(nome.getText().toString())){
                    nome.setError("Digite o nome completo!");
                    nome.requestFocus();
                    isDadosOK = false;
                }
                if(TextUtils.isEmpty(telefone.getText().toString())){
                    nome.setError("Digite o telefone !");
                    nome.requestFocus();
                    isDadosOK = false;
                }
                if(TextUtils.isEmpty(email.getText().toString())){
                    nome.setError("Digite o email!");
                    nome.requestFocus();
                    isDadosOK = false;
                }
                if(TextUtils.isEmpty(cep.getText().toString())){
                    nome.setError("Digite o CEP!");
                    nome.requestFocus();
                    isDadosOK = false;
                }
                if(TextUtils.isEmpty(logradouro.getText().toString())){
                    nome.setError("Digite o logradouro!");
                    nome.requestFocus();
                    isDadosOK = false;
                }
                if(TextUtils.isEmpty(numero.getText().toString())){
                    nome.setError("Digite o número!");
                    nome.requestFocus();
                    isDadosOK = false;
                }
                if(TextUtils.isEmpty(bairro.getText().toString())){
                    nome.setError("Digite o bairro!");
                    nome.requestFocus();
                    isDadosOK = false;
                }
                if(TextUtils.isEmpty(cidade.getText().toString())){
                    nome.setError("Digite a cidade!");
                    nome.requestFocus();
                    isDadosOK = false;
                }
                if(TextUtils.isEmpty(estado.getText().toString())){
                    nome.setError("Digite o estado!");
                    nome.requestFocus();
                    isDadosOK = false;
                }


                if(isDadosOK){

                    novoCliente.setNome(nome.getText().toString());
                    novoCliente.setTelefone(telefone.getText().toString());
                    novoCliente.setEmail(email.getText().toString());
                    // Cast
                    novoCliente.setCep(Integer.parseInt(cep.getText().toString()));
                    novoCliente.setLogradouro(logradouro.getText().toString());

                    //clienteController.incluir(novoCliente);
                } else {
                    // notificar o usuário
                    // toast
                    // push notification



                }

            }
        });

    }
}
