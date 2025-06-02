package com.example.countryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.countryapp.ui.main.RankingFragment;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, RankingFragment.newInstance())
                    .commitNow();
        }
    }
}