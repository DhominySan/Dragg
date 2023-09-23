package com.example.dragg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

import com.example.dragg.activity.HomeActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_LOW");
        MyReceiver objReceiver = new MyReceiver();
        registerReceiver(objReceiver, intentFilter);


        AppCompatButton btnOutros = findViewById(R.id.btnOutros);
        AppCompatButton btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(MenuActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        AppCompatButton btnJogos = findViewById(R.id.btnJogos);
        btnJogos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(MenuActivity.this, Jogos1Activity.class);
                startActivity(intent);
            }
        });
        AppCompatButton btnImagens = findViewById(R.id.btnImagens);
        btnImagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnOutros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(MenuActivity.this, OutrosActivity.class);
                startActivity(intent);
            }
        });


    }
}