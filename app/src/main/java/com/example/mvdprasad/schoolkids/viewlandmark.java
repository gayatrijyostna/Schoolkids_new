package com.example.mvdprasad.schoolkids;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class viewlandmark extends FragmentActivity implements OnMapReadyCallback {
    private MapFragment fragment;
    private GoogleMap googleMap;
    private double markerLat;
    private double markerLong;
    private MarkerOptions markerPlace;
    Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlandmark);
        initilizeMap();
        markerLat = 17.7856;
        markerLong = 78.8956;

    }

    private void initilizeMap() {
        if (googleMap == null) {
            fragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapPlaces);
            fragment.getMapAsync(new MapCallback());
            return;
        }
        Toast.makeText(getApplicationContext(), "Sorry! unable to create maps", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    class MapCallback implements OnMapReadyCallback {

        public void onMapReady(GoogleMap Maps) {
            googleMap = Maps;
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            if (ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0
                    || ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                googleMap.setMyLocationEnabled(true);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setMyLocationButtonEnabled(true);
                googleMap.getUiSettings().setCompassEnabled(true);
                googleMap.getUiSettings().setRotateGesturesEnabled(true);
                googleMap.getUiSettings().setZoomGesturesEnabled(true);
                googleMap.isTrafficEnabled();
                googleMap.setTrafficEnabled(false);

            }
            markerPlace = new MarkerOptions().position(new LatLng(markerLat,markerLong)).title("Name");
            marker = googleMap.addMarker(markerPlace);
        }
    }

}
