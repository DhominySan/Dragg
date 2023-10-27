package com.example.dragg;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.dragg.activity.HomeActivity;

public class ImagensFragment extends Fragment {

    public ImagensFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_imagens, container, false);

        // Referencie o botão do layout
        Button btnVoltarCriador = view.findViewById(R.id.btnVoltarCriador);

        // Adicione um ouvinte de clique ao botão
        btnVoltarCriador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crie uma intenção para abrir a atividade desejada (substitua SuaAtividadeDesejada.class)
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
