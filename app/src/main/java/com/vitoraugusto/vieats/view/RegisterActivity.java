package com.vitoraugusto.vieats.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitoraugusto.vieats.R;
import com.vitoraugusto.vieats.model.Pessoa;

public class RegisterActivity extends AppCompatActivity {

    EditText nome, cpf, senha, email;

    Button cadastrar;
    Pessoa pessoa;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        nome = findViewById(R.id.nome);
        cpf = findViewById(R.id.cpf);
        senha = findViewById(R.id.senha);
        email = findViewById(R.id.email);
        cadastrar = findViewById(R.id.realizarC);


        cadastrar.setOnClickListener(v -> {
            String nom = nome.getText().toString().trim();
            String cp = cpf.getText().toString().trim();
            String emai = email.getText().toString().trim();
            String senh = senha.getText().toString().trim();

            if (nom.isEmpty() || cp.isEmpty() || emai.isEmpty() || senh.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Preencha todos os Campos", Toast.LENGTH_SHORT).show();
            } else {
                Pessoa pessoa = new Pessoa(nom, cp, emai, senh);
                Toast.makeText(RegisterActivity.this, "Cadastro Finalizado!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}