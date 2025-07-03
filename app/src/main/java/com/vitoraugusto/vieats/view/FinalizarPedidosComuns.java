package com.vitoraugusto.vieats.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitoraugusto.vieats.R;

public class FinalizarPedidosComuns extends AppCompatActivity {
ImageView voltar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_finalizarpedidos);
    voltar = findViewById(R.id.voltar);

    voltar.setOnClickListener(v ->{
        Intent intent = new Intent(FinalizarPedidosComuns.this, ComunsComprarActivity.class);
        startActivity(intent);
    });
    }
}