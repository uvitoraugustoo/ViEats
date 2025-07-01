package com.vitoraugusto.vieats.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitoraugusto.vieats.R;

public class ComunsActivity extends AppCompatActivity {
    ImageView voltar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_comuns);

        voltar = findViewById(R.id.voltar);

        voltar.setOnClickListener(v->{
            Intent intent = new Intent(ComunsActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }


}
