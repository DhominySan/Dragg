package com.example.dragg.jogos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dragg.R;
import com.example.dragg.generos.OfflineActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.view.View;
import android.net.Uri;
import android.widget.Button;

public class TombMask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomb_mask);

        //botao com link
        Button baixarTombMask = findViewById(R.id.baixarTombMask);
        baixarTombMask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // URL que você deseja abrir no navegador
                String url = "https://play.google.com/store/apps/details?id=com.playgendary.tom";

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
        AppCompatButton btnVoltarTombMask = findViewById(R.id.btnVoltarTombMask);
        btnVoltarTombMask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(TombMask.this, OfflineActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // FINAL BOTAO VOLTAR
    }
}