package com.example.a12maps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

public class MainActivity extends AppCompatActivity {
    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapView = findViewById(R.id.mapView);
        setupMap();
    }
    private void setupMap() {
        if (mMapView != null) {

            Basemap.Type basemapType = Basemap.Type.STREETS_VECTOR;
            double latitude = -20.761782;
            double longitude = -42.867814;
            int levelOfDetail = 13;
            ArcGISMap map = new ArcGISMap(basemapType, latitude,
                    longitude, levelOfDetail);
            mMapView.setMap(map);
        }
    }
    @Override
    protected void onPause() {
        if (mMapView != null) {
            mMapView.pause();
        }
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (mMapView != null) {
            mMapView.resume();
        }
    }
    @Override
    protected void onDestroy() {
        if (mMapView != null) {
            mMapView.dispose();
        }
        super.onDestroy();
    }
}