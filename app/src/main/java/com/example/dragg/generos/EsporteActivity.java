package com.example.dragg.generos;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.content.Intent;
import com.example.dragg.Jogos1Activity;
import com.example.dragg.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.dragg.jogos.BallPool;
import com.example.dragg.jogos.FifaM;
import com.example.dragg.jogos.FreeF;
import com.example.dragg.jogos.Kimetsu;
import com.example.dragg.jogos.MainUfc;
import com.example.dragg.jogos.MbLegends;
import com.example.dragg.jogos.NBA_Live;
import com.example.dragg.jogos.PingPong;
import com.example.dragg.jogos.TheSpike;

public class EsporteActivity extends Activity {
    private SearchView searchView;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> originalItems;
    private List<String> filteredItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esporte);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);

        originalItems = new ArrayList<>();
        Collections.addAll(originalItems, "UFC 2", "NBA Live", "The Spike", "Ping Pong Fury", "8 Ball Pool");

        // Fazer uma cópia dos dados originais para a lista de filtragem.
        filteredItems = new ArrayList<>(originalItems);

        // Classificar a lista de filtragem (O(n log n)).
        Collections.sort(filteredItems);

        // Criar um adaptador para a ListView.
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filteredItems);
        listView.setAdapter(adapter);

        // Configurar filtro para o SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filteredItems.clear();

                for (String item : originalItems) {
                    if (item.toLowerCase().contains(newText.toLowerCase())) {
                        filteredItems.add(item);
                    }
                }

                adapter.notifyDataSetChanged();

                return true;
            }
        });

        // Lidar com cliques no ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Determinar qual Activity iniciar com base no item selecionado
                Intent intent;
                if (selectedItem.equals("UFC 2")) {
                    intent = new Intent(EsporteActivity.this, MainUfc.class);
                } else if (selectedItem.equals("NBA Live")) {
                    intent = new Intent(EsporteActivity.this, NBA_Live.class);
                } else if (selectedItem.equals("The Spike")) {
                    intent = new Intent(EsporteActivity.this, TheSpike.class);
                } else if (selectedItem.equals("Ping Pong Fury")) {
                    intent = new Intent(EsporteActivity.this, PingPong.class);
                } else if (selectedItem.equals("8 Ball Pool")) {
                    intent = new Intent(EsporteActivity.this, BallPool.class);
                } else {
                    // Caso padrão, se nenhum item corresponder
                    intent = new Intent(EsporteActivity.this, EsporteActivity.class);
                }

                startActivity(intent);
                finish();
            }
        });

        AppCompatButton btnVoltarEsporte = findViewById(R.id.btnVoltarEsporte);
        btnVoltarEsporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(EsporteActivity.this, Jogos1Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
