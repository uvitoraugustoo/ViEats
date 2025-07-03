package com.vitoraugusto.vieats.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitoraugusto.vieats.R;

public class ComunsActivity extends AppCompatActivity {
    ImageView voltar, img1;
    TextView textoImg1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_comuns);

        voltar = findViewById(R.id.voltar);
        img1 = findViewById(R.id.img1);
        textoImg1 = findViewById(R.id.textoImg1);

        voltar.setOnClickListener(v -> {
            Intent intent = new Intent(ComunsActivity.this, MainActivity.class);
            startActivity(intent);
        });

        img1.setOnClickListener(v -> {
            Intent intent = new Intent(ComunsActivity.this, ComunsComprarActivity.class);
            startActivity(intent);
        });

        textoImg1.setOnClickListener(v ->{
            Intent intent = new Intent(ComunsActivity.this, ComunsComprarActivity.class);
            startActivity(intent);
        });

    }


}
