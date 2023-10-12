package com.example.dragg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Recomendado2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendado2);





        //botao para voltar
        AppCompatButton btnVoltarRecomendado2 = findViewById(R.id.btnVoltarRecomendado2);
        btnVoltarRecomendado2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(Recomendado2Activity.this, Jogos1Activity.class);
                startActivity(intent);
            }
        });

        AppCompatButton btnVulgo1 = findViewById(R.id.btnVulgo1);
        btnVulgo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(Recomendado2Activity.this, Recomendado1Activity.class);
                startActivity(intent);
            }
        });
    }
}