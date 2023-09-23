package com.example.dragg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Jogos1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogos1);


        AppCompatButton btnRecomendado = findViewById(R.id.btnRecomendado);
        btnRecomendado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(Jogos1Activity.this, Recomendado1Activity.class);
                startActivity(intent);
            }
        });

        AppCompatButton btnAnime = findViewById(R.id.btnAnime);
        btnAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(Jogos1Activity.this, AnimeActivity.class);
                startActivity(intent);
            }
        });

        AppCompatButton btnEsporte = findViewById(R.id.btnEsporte);
        btnEsporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(Jogos1Activity.this, EsporteActivity.class);
                startActivity(intent);
            }
        });

        AppCompatButton btnOffline = findViewById(R.id.btnOffline);
        btnOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(Jogos1Activity.this, OfflineActivity.class);
                startActivity(intent);
            }
        });

        AppCompatButton btnVoltar5 = findViewById(R.id.btnVoltar5);
        btnVoltar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(Jogos1Activity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

    }
}