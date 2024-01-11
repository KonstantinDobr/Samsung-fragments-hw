package com.example.testandroid1101_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.testandroid1101_2.databinding.ActivityMainBinding;
import com.example.testandroid1101_2.fragment.FirstFragment;
import com.example.testandroid1101_2.fragment.SecondFragment;
import com.example.testandroid1101_2.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fragmentManager;
    private SecondFragment secondFragment;
    private FirstFragment firstFragment;
    private ThirdFragment thirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();

        firstFragment = (FirstFragment) fragmentManager.getFragments().get(0);
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();

        binding.btnFr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager.beginTransaction()
                        .replace(R.id.fc_main, secondFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        binding.btnFr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager.beginTransaction()
                        .replace(R.id.fc_main, firstFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        binding.btnFr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager.beginTransaction().
                        replace(R.id.fc_main, thirdFragment).
                        addToBackStack(null).
                        commit();
            }
        });
    }
}