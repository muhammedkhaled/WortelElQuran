package com.example.ertaqiwratel.presentation.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ertaqiwratel.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

}