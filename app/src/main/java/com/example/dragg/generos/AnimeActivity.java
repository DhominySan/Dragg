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
import com.example.dragg.jogos.ClashR;
import com.example.dragg.jogos.DragonBall;
import com.example.dragg.jogos.FifaM;
import com.example.dragg.jogos.FreeF;
import com.example.dragg.jogos.Kimetsu;
import com.example.dragg.jogos.MbLegends;
import com.example.dragg.jogos.MyHero;
import com.example.dragg.jogos.Naruto;
import com.example.dragg.jogos.OnePiece;
import com.example.dragg.jogos.PecadosCapitais;

public class AnimeActivity extends Activity {

    private SearchView searchView;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] items = {"Dragon Ball Legends", "Naruto - Ninja Voltage", "The Seven Deadly Sins", "One Piece Bounty Rush", "MY HERO ULTRA IMPACT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

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
                if (selectedItem.equals("Dragon Ball Legends")) {
                    intent = new Intent(AnimeActivity.this, DragonBall.class);
                } else if (selectedItem.equals("Naruto - Ninja Voltage")) {
                    intent = new Intent(AnimeActivity.this, Naruto.class);
                } else if (selectedItem.equals("The Seven Deadly Sins")) {
                    intent = new Intent(AnimeActivity.this, PecadosCapitais.class);
                }else if (selectedItem.equals("One Piece Bounty Rush")) {
                    intent = new Intent(AnimeActivity.this, OnePiece.class);
                }else if (selectedItem.equals("MY HERO ULTRA IMPACT")) {
                    intent = new Intent(AnimeActivity.this, MyHero.class);
                }else if (selectedItem.equals("Item 6")) {
                    intent = new Intent(AnimeActivity.this, ClashR.class);
                }


                else {
                    // Caso padrão, se nenhum item corresponder
                    intent = new Intent(AnimeActivity.this, AnimeActivity.class);
                }

                startActivity(intent);
                finish();
            }

        });

        AppCompatButton btnVoltarAnime = findViewById(R.id.btnVoltarAnime);
        btnVoltarAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Trocar para a SecondActivity quando o botão for clicado
                Intent intent = new Intent(AnimeActivity.this, Jogos1Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
