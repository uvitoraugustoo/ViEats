package com.vitoraugusto.vieats.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

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
