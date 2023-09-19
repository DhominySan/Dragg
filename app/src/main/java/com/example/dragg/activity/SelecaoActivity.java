package com.example.dragg.activity;

import static android.hardware.biometrics.BiometricManager.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.hardware.biometrics.BiometricManager;
import android.os.Bundle;

import com.example.dragg.ImagensFragment;
import com.example.dragg.InicioFragment;
import com.example.dragg.MusicFragment;
import com.example.dragg.R;
import com.example.dragg.databinding.ActivitySelecaoBinding;

public class SelecaoActivity extends AppCompatActivity {

    ActivitySelecaoBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelecaoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new InicioFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();
            Fragment fragment = null;

            if (itemId == R.id.inicio) {
                fragment = new InicioFragment();
            } else if (itemId == R.id.imagens) {
                fragment = new ImagensFragment();
            } else if (itemId == R.id.musica) {
                fragment = new MusicFragment();
            }

            if (fragment != null) {
                replaceFragment(fragment);
            }


            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }
}