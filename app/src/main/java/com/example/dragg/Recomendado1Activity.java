package com.example.dragg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.content.Intent;

import com.example.dragg.ClashR;

public class Recomendado1Activity extends Activity {

    private SearchView searchView;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] items = {"Clash Royale", "Free Fire", "Mobile Legends", "EA Sports FC", "Kimetsu Fight"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendado1);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        // Configurar filtro para o SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
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
                if (selectedItem.equals("Clash Royale")) {
                    intent = new Intent(Recomendado1Activity.this, ClashR.class);
                } else if (selectedItem.equals("Free Fire")) {
                    intent = new Intent(Recomendado1Activity.this, FreeF.class);
                } else if (selectedItem.equals("Mobile Legends")) {
                    intent = new Intent(Recomendado1Activity.this, MbLegends.class);
                }else if (selectedItem.equals("EA Sports FC")) {
                    intent = new Intent(Recomendado1Activity.this, FifaM.class);
                }else if (selectedItem.equals("Kimetsu Fight")) {
                    intent = new Intent(Recomendado1Activity.this, Kimetsu.class);
                }else if (selectedItem.equals("Item 6")) {
                    intent = new Intent(Recomendado1Activity.this, ClashR.class);
                }


                else {
                    // Caso padrão, se nenhum item corresponder
                    intent = new Intent(Recomendado1Activity.this, Recomendado1Activity.class);
                }

                startActivity(intent);
            }

        });

        AppCompatButton btnVoltarRecomendado = findViewById(R.id.btnVoltarRecomendado);
        btnVoltarRecomendado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(Recomendado1Activity.this, Jogos1Activity.class);
                startActivity(intent);
            }
        });
    }
}
