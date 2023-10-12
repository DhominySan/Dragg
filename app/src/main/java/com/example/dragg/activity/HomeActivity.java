package com.example.dragg.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.Executor;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dragg.MainActivity;
import com.example.dragg.MenuActivity;
import com.example.dragg.R;
import com.example.dragg.Util.ConfiguracaoBd;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;


public class HomeActivity extends AppCompatActivity {


    private FirebaseAuth auth;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = ConfiguracaoBd.Firebaseautenticacao();

        executor = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(HomeActivity.this, "Erro de autenticação: " + errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                // Autenticação bem-sucedida, vá para a próxima atividade
                Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(HomeActivity.this, "Falha na autenticação", Toast.LENGTH_SHORT).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Autenticação com Biometria")
                .setSubtitle("Toque no sensor de biometria")
                .setNegativeButtonText("Cancelar")
                .build();

        Button biometricButton = findViewById(R.id.biometricButton);
        biometricButton.setOnClickListener(view -> {
            biometricPrompt.authenticate(promptInfo);
        });

    }

    public void comecaar(View v){
        Intent i = new Intent(this, SelecaoActivity.class);
        startActivity(i);
    }

    public void testbaixar(View v){
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }


    public void deslogar(View view){
        try{
            auth.signOut();
            finish();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}