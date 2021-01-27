package com.example.gps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.webkit.WebView;
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

    public void buscar_gps(View view) {

        LocationManager mLocManager = null;
        LocationListener mLocListener;
        mLocManager = (LocationManager)
                getSystemService(MainActivity.this.LOCATION_SERVICE);
        mLocListener = new MyLocationListener();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                0, 0, mLocListener);
        if(mLocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            String texto="Latitude: " + MyLocationListener.latitude + "\n";
            texto+="Longitude: " + MyLocationListener.longitude + "\n";
            Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG).show();
        } //gps habilitado
        else{
            Toast.makeText(MainActivity.this, "GPS DESABILITADO.",
                    Toast.LENGTH_LONG).show();
        }

        Toast.makeText(getApplicationContext(), String.valueOf(MyLocationListener.latitude), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), String.valueOf(MyLocationListener.longitude), Toast.LENGTH_SHORT).show();

        if(MyLocationListener.latitude < -1) {
            WebView wv = findViewById(R.id.webv);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.loadUrl("https://www.google.com/maps/search/?api=1&query=" +
                    MyLocationListener.latitude + "," +
                    MyLocationListener.longitude);
        }

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


}
