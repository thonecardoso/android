package com.example.a06service2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrir2(View v){
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        i.putExtra("nomealuno", "Maria");

        startActivityForResult(i,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) { // verificar se é a sua requisição
            if (resultCode == RESULT_OK) { // verificar se foi bem sucedida
                String disciplina = data.getStringExtra("disciplina");
                TextView tv = (TextView) findViewById(R.id.textView2);
                tv.setText(disciplina);
            }
        }
    }
}