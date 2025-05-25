package com.example.countryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.countryapp.ui.main.ClassReservationFragment;

public class ClassReservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_reservation);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ClassReservationFragment.newInstance())
                    .commitNow();
        }
    }
}