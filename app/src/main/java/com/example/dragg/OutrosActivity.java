package com.example.dragg;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.dragg.activity.HomeActivity;
import com.example.dragg.activity.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OutrosActivity extends AppCompatActivity {

    private ImageView profileImageView;
    private ImageView gifImageView;
    private TextView emailTextView;
    private Button logoutButton;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outros);

        profileImageView = findViewById(R.id.profileImageView);
        emailTextView = findViewById(R.id.emailTextView);
        logoutButton = findViewById(R.id.logoutButton);

        firebaseAuth = FirebaseAuth.getInstance();

        gifImageView = findViewById(R.id.gifImageView);

        // Carregando e exibindo o GIF usando Glide
        Glide.with(this)
                .asGif()
                .load(R.drawable.lolii) // Substitua
                .diskCacheStrategy(DiskCacheStrategy.DATA) // Evita o cache do GIF
                .into(gifImageView);

        // Verifique se o usuário está logado
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            emailTextView.setText(user.getEmail());
        }

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Realize o logout do usuário
                firebaseAuth.signOut();
                // Redirecione o usuário para a tela de login
                startActivity(new Intent(OutrosActivity.this, LoginActivity.class));
                finish();
            }
        });


        AppCompatButton btnVoltarOutros = findViewById(R.id.btnVoltarOutros);
        btnVoltarOutros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(OutrosActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

