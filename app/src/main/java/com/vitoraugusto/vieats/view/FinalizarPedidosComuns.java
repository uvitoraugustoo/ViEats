package com.vitoraugusto.vieats.view;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.vitoraugusto.vieats.R;
import com.vitoraugusto.vieats.controller.FinalizarPedidosController;

public class FinalizarPedidosComuns extends AppCompatActivity {
    ImageView voltar;
    Spinner spinnerPagamento, spinnerTipo;
    Button finalizarPedido;
    EditText endereco, numeroEndereco;


    FinalizarPedidosController preferencesController;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_finalizarpedidos);

        criarNotificacao();

        endereco = findViewById(R.id.endereco);
        numeroEndereco = findViewById(R.id.numeroEndereco);
        voltar = findViewById(R.id.voltar);
        spinnerPagamento = findViewById(R.id.spinnerPagamento);
        spinnerTipo = findViewById(R.id.spinnerTipo);
        finalizarPedido = findViewById(R.id.finalizarPedido);
        preferencesController = new FinalizarPedidosController(this);


        voltar.setOnClickListener(v -> {
            Intent intent = new Intent(FinalizarPedidosComuns.this, ComunsComprarActivity.class);
            startActivity(intent);
        });

        String[] formasDePagamento = {"Selecione", "Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Pix"};
        String[] tipoPedido = {"Selecione", "Entrega", "Retirada no Local"};

        ArrayAdapter<String> adapterPagamento = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, formasDePagamento
        );
        adapterPagamento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPagamento.setAdapter(adapterPagamento);

        ArrayAdapter<String> adapterTipo = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, tipoPedido
        );
        adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipo.setAdapter(adapterTipo);

        endereco.setText(preferencesController.getEndereco());
        numeroEndereco.setText(preferencesController.getNumeroEndereco());
        spinnerPagamento.setSelection(preferencesController.getPagamento());
        spinnerTipo.setSelection(preferencesController.getTipo());

        finalizarPedido.setOnClickListener(v -> {
            preferencesController.salvarSelecoes(
                    endereco.getText().toString(),
                    numeroEndereco.getText().toString(),
                    spinnerPagamento.getSelectedItemPosition(),
                    spinnerTipo.getSelectedItemPosition()

            );
            Toast.makeText(FinalizarPedidosComuns.this, "Seu pedido foi realizado!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FinalizarPedidosComuns.this, MainActivity.class);
            startActivity(intent);
            enviarNotificacao();
        });

    }

    private void enviarNotificacao() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "canal_viEats")
                .setSmallIcon(R.drawable.vieats)
                .setContentTitle("Pedido Confirmado")
                .setContentText("Seu pedido foi confirmado, agradecemos pela preferência")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            notificationManager.notify(1, builder.build());
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
        }
    }

    private void criarNotificacao() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel canal = new NotificationChannel(
                    "canal_viEats",
                    "Notificações ViEats",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            canal.setDescription("Canal para notificações de pedidos");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(canal);
        }
    }

}


