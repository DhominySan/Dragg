package com.example.dragg;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDownload = findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verificar se a permissão de escrita externa foi concedida
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Se a permissão não foi concedida, solicite-a
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            REQUEST_WRITE_EXTERNAL_STORAGE);
                } else {
                    // Se a permissão já foi concedida, inicie o download
                    iniciarDownload();
                }
            }
        });
    }

    private void iniciarDownload() {
        // URL da imagem que você deseja baixar
        String imageUrl = "https://i.pinimg.com/564x/2f/5d/90/2f5d9046f016014ef7719ad241983293.jpg";

        // Crie uma solicitação de download usando o DownloadManager
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(imageUrl));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Download de Imagem");
        request.setDescription("Baixando imagem para a galeria...");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "imgvalir.jpg");


        // Obtenha o serviço do DownloadManager e inicie o download
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        long downloadID = downloadManager.enqueue(request);

        // Exibir uma mensagem para o usuário
        Toast.makeText(this, "Iniciando o download da imagem...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permissão concedida, inicie o download
                iniciarDownload();
            } else {
                // Permissão negada, informe ao usuário
                Toast.makeText(this, "Permissão de armazenamento negada. Não é possível baixar a imagem.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void indoprafragment(View v){
        Intent i = new Intent(this, ImagensFragment.class);
        startActivity(i);
    }


}
