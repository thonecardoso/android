package com.example.javascript;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView browser;
        browser = (WebView) findViewById(R.id.webkit);
        WebSettings webSettings = browser.getSettings();

        //browser.addJavascriptInterface(new AndroidJSWebView.WebAppInterface(this), "Android");
        browser.loadUrl("file:///android_asset/pagina.html");
        webSettings.setJavaScriptEnabled(true);
    }

    public class WebAppInterface{

        Context mContext;

        WebAppInterface(Context c){
            mContext = c;
        }

        public void showToast(String toast){
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

        public void showDialog(String dialogMsg){
            AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();

            alertDialog.setTitle("JS triggered Dialog");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(mContext, "Fechar Dialog", Toast.LENGTH_SHORT).show();

                }
            });

            alertDialog.show();
        }
    }
}
