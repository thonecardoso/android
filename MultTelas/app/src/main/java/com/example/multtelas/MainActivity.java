package com.example.multtelas;

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


    public void questao1(View view) {
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }

    public void quertao2(View view) {
        Intent i = getPackageManager().getLaunchIntentForPackage("com.miui.calculator");
        startActivity(i);
    }
}
