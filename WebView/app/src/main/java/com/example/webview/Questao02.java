package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class Questao02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao02);
    }

    public void Ir(View view) {
        EditText e = findViewById(R.id.editUrl);
        String url = e.getText().toString();

        WebView wb = new WebView(this);
        setContentView(wb);
        wb.loadUrl(url);
    }

    public void siteIftm(View view) {
        WebView wb = new WebView(this);
        setContentView(wb);
        wb.loadUrl("https://www.google.com.br");
    }
}
