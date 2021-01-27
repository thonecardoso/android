package com.example.a05service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarServico(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void pararServico(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}