package com.example.aulacomando;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AulaPDM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "ON CREATE");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"on START");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"on RESTART");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"on RESUME");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"on PAUSE");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"on STOP");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "on DESTROY");
    }
}
