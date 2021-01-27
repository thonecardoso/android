package com.example.a06service2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent mIntent = getIntent();
        String nome = mIntent.getStringExtra("nomealuno");

        n=nome;
    }



    public void textview(View view) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(n);
        fechar();
    }

    public void fechar(){
        Intent data = new Intent();
        data.putExtra("disciplina","pdm");
        setResult(RESULT_OK,data);
        finish();
    }
}