package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("recebedorsms","recebendo msg1111");


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.RECEIVE_SMS},
                    999);
        }

    }

    public void smsPadao(View v){
        Uri uri = Uri.parse("smsto:12345678");
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
        smsIntent.putExtra("sms_body","MENSAGEM A SER ENVIADA");
        startActivity(smsIntent);
    }

    public void Abrir(View view) {
        Intent i = new Intent(MainActivity.this, smsJava.class);
        startActivity(i);
    }



}
