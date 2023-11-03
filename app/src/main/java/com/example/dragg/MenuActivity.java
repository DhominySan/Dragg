package com.example.dragg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.example.dragg.activity.HomeActivity;

public class MenuActivity extends AppCompatActivity {

    private static final int STORAGE_PERMISSION_REQUEST_CODE = 101;
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
                finish();
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





        // Permissao para acessar o armazenamento

        if (checkStoragePermission()) {
            // Você já tem permissão
            // Faça o que você precisa fazer aqui
        } else {
            // Solicita permissão se ainda não a tiver
            requestStoragePermission();
        }
    }

    // Verifica se a permissão de armazenamento já foi concedida
    private boolean checkStoragePermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    // Solicita permissão de armazenamento
    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_REQUEST_CODE);
    }

    // Trata o resultado da solicitação de permissão
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults); // Adicione esta linha

        if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Imagens serão baixadas corretamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permissão de armazenamento necessária", Toast.LENGTH_SHORT).show();
            }
        }
    }
    }
