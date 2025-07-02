package com.vitoraugusto.vieats.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitoraugusto.vieats.R;
import com.vitoraugusto.vieats.controller.PessoaController;
import com.vitoraugusto.vieats.model.Pessoa;

public class RegisterActivity extends AppCompatActivity {
   private EditText nome, cpf, senha, email;
    private Button cadastrar;
    private Pessoa pessoa;
    private PessoaController pessoaController;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        pessoaController = new PessoaController(this);

        nome = findViewById(R.id.nome);
        cpf = findViewById(R.id.cpf);
        senha = findViewById(R.id.senha);
        email = findViewById(R.id.email);
        cadastrar = findViewById(R.id.realizarC);

        cadastrar.setOnClickListener(v -> {
            String nom = nome.getText().toString().trim();
            String emai = email.getText().toString().trim();
            String senh = senha.getText().toString().trim();
            String cp = cpf.getText().toString().trim();

            if (nom.isEmpty() || cp.isEmpty() || emai.isEmpty() || senh.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Preencha todos os Campos", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(RegisterActivity.this, "Cadastro Finalizado!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);

                pessoa = new Pessoa(
                        nome.getText().toString(),
                        email.getText().toString(),
                        senha.getText().toString(),
                        cpf.getText().toString()
                );
                pessoaController.salvarPessoa(pessoa);

                Toast.makeText(RegisterActivity.this, "Dados Salvos", Toast.LENGTH_SHORT).show();
            }
        });
        carregarPessoaSalva();
    }
    public void carregarPessoaSalva() {
        Pessoa pessoa2 = pessoaController.carregarPessoa();
        nome.setText(pessoa2.getNome());
        email.setText(pessoa2.getEmail());
        senha.setText(pessoa2.getSenha());
        cpf.setText(pessoa2.getCpf());
    }
}
