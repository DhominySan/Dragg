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
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.DownloadManager;
import android.net.Uri;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDownload = findViewById(R.id.btnDownload);
        // Defina onClickListener para o primeiro botão
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para baixar a primeira imagem da internet
                downloadImage("https://e0.pxfuel.com/wallpapers/191/255/desktop-wallpaper-progress-royale-clash-of-clans-pekka.jpg");
            }
        });
        //
        Button btnDownload2 = findViewById(R.id.btnDownload2);
        // Defina onClickListener para o primeiro botão
        btnDownload2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para baixar a primeira imagem da internet
                downloadImage("https://wonder-day.com/wp-content/uploads/2021/02/wonder-day-wallpaper-free-fire-iphone-17.jpg");
            }
        });
        //
        Button btnDownload3 = findViewById(R.id.btnDownload3);
        // Defina onClickListener para o primeiro botão
        btnDownload3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para baixar a primeira imagem da internet
                downloadImage("https://e0.pxfuel.com/wallpapers/229/956/desktop-wallpaper-dyrroth-skins-mobile-legends-bang-bang-dyrroth-mobile-legend.jpg");
            }
        });

        Button btnDownload4 = findViewById(R.id.btnDownload4);
        // Defina onClickListener para o primeiro botão
        btnDownload4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para baixar a primeira imagem da internet
                downloadImage("https://e1.pxfuel.com/desktop-wallpaper/270/1017/desktop-wallpaper-vinicius-junior.jpg");
            }
        });

        Button btnDownload5 = findViewById(R.id.btnDownload5);
        // Defina onClickListener para o primeiro botão
        btnDownload5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para baixar a primeira imagem da internet
                downloadImage("https://e0.pxfuel.com/wallpapers/770/704/desktop-wallpaper-demon-slayer-mobile-top-10-best-demon-slayer-mobile-background-demonic-phone.jpg");
            }
        });

        // Repita o processo para os outros botões e URLs de imagens








        //botao voltar
        AppCompatButton voltar1 = findViewById(R.id.voltar1);
        voltar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void downloadImage(String url) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Download de Imagem");
        request.setDescription("Baixando imagem para a galeria...");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Imagem.jpg");


        // Obtenha o serviço do DownloadManager e inicie o download
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        long downloadID = downloadManager.enqueue(request);

        // Exibir uma mensagem para o usuário
        Toast.makeText(this, "Iniciando o download da imagem...", Toast.LENGTH_SHORT).show();
    }







}



