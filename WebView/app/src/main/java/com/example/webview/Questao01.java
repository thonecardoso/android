package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class Questao01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao01);
        Toast.makeText(this, "Abrindo WebView", Toast.LENGTH_SHORT).show();

        WebView wb = new WebView(this);
        setContentView(wb);

        String load = "<html><body><h1> Questão 01 </h1></body></html>";

        wb.loadData(load, "text/html", null);
    }
}
