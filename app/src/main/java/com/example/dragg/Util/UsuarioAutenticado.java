package com.example.dragg.Util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UsuarioAutenticado {

    public static FirebaseUser usuariologado(){
        FirebaseAuth usuario = ConfiguracaoBd.Firebaseautenticacao();
        return usuario.getCurrentUser();
    }

}
