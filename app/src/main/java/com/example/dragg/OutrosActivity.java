package com.example.dragg;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.dragg.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class OutrosActivity extends AppCompatActivity {

    private static final int GALLERY_INTENT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outros);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            String nome = user.getDisplayName();
            String email = user.getEmail();

            // Suponha que você tenha dois TextViews na sua interface com IDs "nomeTextView" e "emailTextView".
            TextView nomeTextView = findViewById(R.id.textNomeUsuario);
            TextView emailTextView = findViewById(R.id.textEmailUsuario);

            // Atualize os TextViews com as informações do usuário.
            nomeTextView.setText(nome);
            emailTextView.setText(email);
        }

        Button selecionarImagemButton = findViewById(R.id.selecionarImagemButton);

        selecionarImagemButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, GALLERY_INTENT);
        });




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();

            // Agora você pode fazer upload da imagem para o Firebase Storage.
            StorageReference storageReference = FirebaseStorage.getInstance().getReference()
                    .child("imagens_de_perfil");

            storageReference.putFile(selectedImageUri)
                    .addOnSuccessListener(taskSnapshot -> {
                        // A imagem foi enviada com sucesso.
                        // Agora você pode recuperar a URL da imagem para exibição na interface.
                        storageReference.getDownloadUrl().addOnSuccessListener(uri -> {
                            String imageUrl = uri.toString();
                            // Atualize a imagem de perfil na interface com a URL da imagem.
                        });
                    })
                    .addOnFailureListener(e -> {
                        // Lidar com erros no envio da imagem.
                    });
        }
    }
}
