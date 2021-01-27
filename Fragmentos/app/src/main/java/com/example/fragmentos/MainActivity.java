package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_content, new Fragmento01())
                    .commit();
        }

    }

    public void frag01(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_content, new Fragmento01())
                .commit();
    }

    public void frag02(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_content, new Fragmento02())
                .commit();
    }

    public void remover(View view) {
        for(Fragment fragment:getSupportFragmentManager().getFragments()){
            getSupportFragmentManager().beginTransaction()
                    .remove(fragment).commit();
        }
    }

    public void sub01(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_content, new Fragmento01())
                .commit();
    }

    public void sub02(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_content, new Fragmento02())
                .commit();
    }
}

