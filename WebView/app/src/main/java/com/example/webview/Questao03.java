package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Questao03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao03);

        WebView wb = findViewById(R.id.webQuestao3);
        wb.loadUrl("file:///android_asset/page.html");
    }
}
