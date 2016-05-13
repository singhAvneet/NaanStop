package com.example.owner.assignment2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Owner on 2015-11-25.
 */
public class MapActivity extends Activity {
    static final LatLng TORONTO = new LatLng(43.6426, -79.3871);
    private static GoogleMap map;
    public  MapActivity(){

      //  Bundle extras = getIntent().getExtras();
      //  String contactName = extras.getString("activityName");

        //  this.getSupportActionBar().setTitle(contactName);
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);//MAP_TYPE_SATELLITE
        Marker Toronto = map.addMarker(new MarkerOptions().position(new LatLng(43.663160, -79.421923))
                .title("Toronto - Fall 2015"));

        // Move the camera instantly to toronto with a zoom of 15.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(43.663160, -79.421923), 15));

        // Zoom in, animating the camera.
        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);






    }

}
