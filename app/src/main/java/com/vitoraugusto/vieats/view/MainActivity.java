package com.vitoraugusto.vieats.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitoraugusto.vieats.R;
import com.vitoraugusto.vieats.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    ImageView lupa;
    View comuns, comidaJ, pizzas, saladas, sobremesas, lanches;
    EditText pesquisar;
    ImageView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pesquisar = findViewById(R.id.pesquisar);
        lupa = findViewById(R.id.lupa);
        comuns = findViewById(R.id.overlayComuns);
        comidaJ = findViewById(R.id.overlayJaponesa);
        pizzas = findViewById(R.id.overlayPizza);
        saladas = findViewById(R.id.overlaySalada);
        sobremesas = findViewById(R.id.overlaySobremesas);
        lanches = findViewById(R.id.overlayLanches);
        logout = findViewById(R.id.logout);

        lupa.setOnClickListener(v -> {
            pesquisar.setText("");
        });
        comuns.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, ComunsActivity.class);
            startActivity(intent);
        });
        logout.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}