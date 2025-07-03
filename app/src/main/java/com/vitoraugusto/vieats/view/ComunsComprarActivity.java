package com.vitoraugusto.vieats.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitoraugusto.vieats.R;

public class ComunsComprarActivity extends AppCompatActivity {
    ImageView voltar;
    Button addpedido;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_comunspedido);

        voltar = findViewById(R.id.voltar);
        addpedido = findViewById(R.id.addpedido);

        voltar.setOnClickListener(v -> {

            Intent intent = new Intent(ComunsComprarActivity.this, ComunsActivity.class);
            startActivity(intent);
        });
        addpedido.setOnClickListener(v ->{
            Intent intent = new Intent(ComunsComprarActivity.this, FinalizarPedidosComuns.class);
            startActivity(intent);
        });

    }
}