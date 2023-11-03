package com.example.dragg.jogos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dragg.R;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dragg.R;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.view.View;
import android.net.Uri;
import android.widget.Button;
import com.example.dragg.generos.EsporteActivity;

public class BallPool extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_pool);

        //botao com link
        Button baixar8ball = findViewById(R.id.baixar8ball);
        baixar8ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // URL que você deseja abrir no navegador
                String url = "https://play.google.com/store/apps/details?id=com.miniclip.eightballpool";

                // Cria uma Intent com a ação ACTION_VIEW e a URL como dado
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // Verifica se há um navegador disponível para abrir a URL
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // Se não houver navegador disponível, você pode lidar com isso aqui
                }
            }
        });
        //final botao com link

        //BOTAO VOLTAR
        AppCompatButton btnVoltar8ball = findViewById(R.id.btnVoltar8ball);
        btnVoltar8ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(BallPool.this, EsporteActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // FINAL BOTAO VOLTAR
    }
}