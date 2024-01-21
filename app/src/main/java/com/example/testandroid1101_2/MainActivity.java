package com.example.testandroid1101_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.testandroid1101_2.databinding.ActivityMainBinding;
import com.example.testandroid1101_2.view.MyView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private MyView myView;

    /* private FragmentManager fragmentManager;
    private SecondFragment secondFragment;
    private FirstFragment firstFragment;
    private ThirdFragment thirdFragment; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*binding.btnFr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mvDraw.setPaintColor(getResources().getColor(R.color.red));
            }
        });

        binding.btnFr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mvDraw.setPaintColor(getResources().getColor(R.color.green));
            }
        });

        binding.btnFr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mvDraw.setPaintColor(getResources().getColor(R.color.blue));
            }
        });*/

        /*fragmentManager = getSupportFragmentManager();

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
        });*/
    }

    /*@Override
    public void onBackPressed() {
        binding.mvDraw.cancelLastPath();
    }*/
}