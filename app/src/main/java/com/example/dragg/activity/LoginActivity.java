package com.example.dragg.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dragg.R;
import com.example.dragg.Util.ConfiguracaoBd;
import com.example.dragg.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText campoEmail,campoSenha;
    Button botaoAcessar;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = ConfiguracaoBd.Firebaseautenticacao();
        inicializarComponentes();
    }

public void validarAutenticacao(View view){
        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();
        if (!email.isEmpty()){
            if (!senha.isEmpty()){
                Usuario usuario = new Usuario();
                usuario.setEmail(email);
                usuario.setSenha(senha);
                
                logar(usuario);

            }else{
                Toast.makeText(this, "Insira a senha", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "Insira o Email", Toast.LENGTH_SHORT).show();
        }
}

    private void logar(Usuario usuario) {

        auth.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    abrirHome();
                }else {
                    String excecao="";
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e){
                        excecao = "Usuario não esta cadastrado";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "Email ou senha incorreto";
                    }catch (Exception e){
                        excecao = "Erro ao efetuar login" + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this, excecao, Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void abrirHome() {
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(i);
        finish();
    }


    public void cadastrar(View v){
        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
        finish();
    }

@Override
    protected void onStart() {
        super.onStart();
    FirebaseUser usuarioAuth = auth.getCurrentUser();
    if (usuarioAuth !=null){
        abrirHome();
    }
    }




    private void inicializarComponentes(){
        campoEmail = findViewById(R.id.editTextEmailLogin);
        campoSenha = findViewById(R.id.editTextSenhaLogin);
        botaoAcessar = findViewById(R.id.buttonAcessar);
    }
}