package com.example.dragg.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.biometric.BiometricPrompt;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.biometric.BiometricManager;
import java.util.concurrent.Executor;
import com.example.dragg.MenuActivity;
import com.example.dragg.R;
import com.example.dragg.Util.ConfiguracaoBd;
import com.google.firebase.auth.FirebaseAuth;



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
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(HomeActivity.this, "Erro de autenticação: " + errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
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
            if (isBiometricAvailable()) {
                biometricPrompt.authenticate(promptInfo);
            } else {
                // O dispositivo não suporta biometria, vá diretamente para a MenuActivity
                Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean isBiometricAvailable() {
        BiometricManager biometricManager = BiometricManager.from(this);
        int canAuthenticate = biometricManager.canAuthenticate();
        return canAuthenticate == BiometricManager.BIOMETRIC_SUCCESS;
    }

    public void comecaar(View v){
        Intent i = new Intent(this, SelecaoActivity.class);
        startActivity(i);
        finish();
    }

    public void testbaixar(View v){
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
        finish();
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