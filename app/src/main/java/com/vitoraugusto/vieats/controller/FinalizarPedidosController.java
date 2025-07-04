
package com.vitoraugusto.vieats.controller;

import android.content.Context;
import android.content.SharedPreferences;

public class FinalizarPedidosController {

    private static final String PREFS_NAME = "ViEatsPrefs";
    private static final String KEY_ENDERECO = "endereco";
    private static final String KEY_NUMERO_ENDERECO = "numeroEndereco";

    private static final String KEY_PAGAMENTO = "pagamento";
    private static final String KEY_TIPO = "tipo";

    private SharedPreferences sharedPreferences;

    public FinalizarPedidosController(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void salvarSelecoes(String endereco, String numeroEndereco, int posPagamento, int posTipo) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ENDERECO, endereco);
        editor.putString(KEY_NUMERO_ENDERECO, numeroEndereco);
        editor.putInt(KEY_PAGAMENTO, posPagamento);
        editor.putInt(KEY_TIPO, posTipo);
        editor.apply();
    }

    public int getPagamento() {
        return sharedPreferences.getInt(KEY_PAGAMENTO, 0);
    }

    public int getTipo() {
        return sharedPreferences.getInt(KEY_TIPO, 0);
    }
    public String getEndereco() {
        return sharedPreferences.getString(KEY_ENDERECO, "");
    }

    public String getNumeroEndereco() {
        return sharedPreferences.getString(KEY_NUMERO_ENDERECO, "");
    }
}