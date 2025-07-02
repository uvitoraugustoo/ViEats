package com.vitoraugusto.vieats.controller;




import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.vitoraugusto.vieats.model.Pessoa;


public class PessoaController {



    SharedPreferences sharedPreferences;
    public static final String NOMES_PREFERENCES = "usuarios";


    public PessoaController(Context context) {
        sharedPreferences = context.getSharedPreferences(NOMES_PREFERENCES, 0);
    }

    public void salvarPessoa(Pessoa pessoa) {
        SharedPreferences.Editor listaVip = sharedPreferences.edit();
        listaVip.putString("nome", pessoa.getNome());
        listaVip.putString("email", pessoa.getEmail());
        listaVip.putString("senha", pessoa.getSenha());
        listaVip.putString("cpf", pessoa.getCpf());
        listaVip.apply();
    }


    public Pessoa carregarPessoa() {
        String nome = sharedPreferences.getString("nome", "");
        String email = sharedPreferences.getString("email", "");
        String senha = sharedPreferences.getString("senha", "");
        String cpf = sharedPreferences.getString("cpf", "");
        return new Pessoa(nome, email, senha,cpf);
    }

    @NonNull
    public String toString() {
        Log.d("MVC Controller ", "Controller Iniciado...");
        return super.toString();

    }
}



