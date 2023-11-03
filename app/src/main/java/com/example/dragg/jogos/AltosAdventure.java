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

public class AltosAdventure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altos_adventure);

        //botao com link
        Button baixarAltos = findViewById(R.id.baixarAltos);
        baixarAltos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // URL que você deseja abrir no navegador
                String url = "https://play.google.com/store/apps/details?id=com.noodlecake.altosadventure";

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
        AppCompatButton btnVoltarAltos = findViewById(R.id.btnVoltarAltos);
        btnVoltarAltos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(AltosAdventure.this, OfflineActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // FINAL BOTAO VOLTAR
    }
}