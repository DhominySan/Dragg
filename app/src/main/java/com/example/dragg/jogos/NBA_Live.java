package com.example.dragg.jogos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dragg.R;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.view.View;
import android.net.Uri;
import android.widget.Button;
import com.example.dragg.generos.EsporteActivity;

public class NBA_Live extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nba_live);

        //botao com link
        Button baixarNba = findViewById(R.id.baixarNba);
        baixarNba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // URL que você deseja abrir no navegador
                String url = "https://play.google.com/store/apps/details?id=com.ea.gp.nbamobile";

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
        AppCompatButton btnVoltarNba = findViewById(R.id.btnVoltarNba);
        btnVoltarNba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(NBA_Live.this, EsporteActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // FINAL BOTAO VOLTAR
    }
}