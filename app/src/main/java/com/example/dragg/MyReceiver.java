package com.example.dragg;

import android.content.Context;
import android.content.Intent;

import android.content.BroadcastReceiver;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Este método será chamado quando o Broadcast for recebido.
        // Exiba um Toast na tela.
        Log.i("MyBroadcastReceiver", "Coloque seu Celular para carregar!");
        Toast.makeText(context, "Coloque seu Celular para carregar!", Toast.LENGTH_SHORT).show();
    }
}

