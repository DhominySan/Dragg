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

import com.example.dragg.jogos.AltosAdventure;
import com.example.dragg.jogos.BallPool;
import com.example.dragg.jogos.FifaM;
import com.example.dragg.jogos.FreeF;
import com.example.dragg.jogos.Kimetsu;
import com.example.dragg.jogos.MainUfc;
import com.example.dragg.jogos.MbLegends;
import com.example.dragg.jogos.NBA_Live;
import com.example.dragg.jogos.PingPong;
import com.example.dragg.jogos.ShadowFight;
import com.example.dragg.jogos.StickmanLegends;
import com.example.dragg.jogos.TheSpike;
import com.example.dragg.jogos.TombMask;
import com.example.dragg.jogos.Vectorr;

public class OfflineActivity extends Activity {
    private SearchView searchView;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> originalItems;
    private List<String> filteredItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);

        originalItems = new ArrayList<>();
        Collections.addAll(originalItems, "Shadow Fight 3", "Stickman Legends", "Vector", "Alto's Adventure", "Tomb of the Mask");

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
                if (selectedItem.equals("Shadow Fight 3")) {
                    intent = new Intent(OfflineActivity.this, ShadowFight.class);
                } else if (selectedItem.equals("Stickman Legends")) {
                    intent = new Intent(OfflineActivity.this, StickmanLegends.class);
                } else if (selectedItem.equals("Vector")) {
                    intent = new Intent(OfflineActivity.this, Vectorr.class);
                } else if (selectedItem.equals("Alto's Adventure")) {
                    intent = new Intent(OfflineActivity.this, AltosAdventure.class);
                } else if (selectedItem.equals("Tomb of the Mask")) {
                    intent = new Intent(OfflineActivity.this, TombMask.class);
                } else {
                    // Caso padrão, se nenhum item corresponder
                    intent = new Intent(OfflineActivity.this, OfflineActivity.class);
                }

                startActivity(intent);
                finish();
            }
        });

        AppCompatButton btnVoltarOffline = findViewById(R.id.btnVoltarOffline);
        btnVoltarOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(OfflineActivity.this, Jogos1Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
