package com.example.esp32;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isNetwork(getApplicationContext())){

            Toast.makeText(getApplicationContext(), "Internet Connected", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(getApplicationContext(), "Internet Is Not Connected", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("WrongConstant")
    public void ativarRele(View view) {
        AtivarRele at = new AtivarRele();
        at.execute();
    }

    public void desativarRele(View view) {
        DesativaRele dr = new DesativaRele();
        dr.execute();
    }

    public boolean isNetwork(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public void alarmOff(View view) {
        DesligarAlarme da = new DesligarAlarme();
        da.execute();

    }

    public void Updates(View view) {
        Status st = new Status();
        st.execute();
    }

    public void Test(View view) {
        Test test = new Test();
        test.execute();
    }
}
