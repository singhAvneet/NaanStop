package com.example.owner.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Owner on 2015-09-27.
 */
public class OrderInformation extends Activity {
    static  LatLng TORONTO = new LatLng(43.6426, -79.3871);
    static String reasturant;
    private GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent getintent=getIntent();
        TextView text=(TextView)findViewById(R.id.finalView);
        String details=getintent.getStringExtra("Finalkey");
        reasturant=getintent.getStringExtra("restKey");
        LatLng latlong=initializelatlong(reasturant);
        text.setText(details);
        initialize(latlong,reasturant);
    }

    private LatLng initializelatlong(String reasturant) {

        switch (reasturant) {
            case "Banjara Indian":
                TORONTO = new LatLng(43.663160, -79.421923);

                break;
            case "Little Indian":
                TORONTO = new LatLng(43.650236, -79.388956);

                break;
            case "Lahore Tikka":
                TORONTO = new LatLng(43.672085, -79.322086);

                break;
            case "Swatow Restaurant":
                TORONTO = new LatLng(43.653836, -79.398109);

                break;
            case "Bamboo Buddha":
                TORONTO = new LatLng(43.643529, -79.405104);

                break;
            case "Szechuan Express":
                TORONTO = new LatLng(43.648636, -79.381744);

                break;
            case "Lai Wah Heen":
                TORONTO = new LatLng(43.654671, -79.386172);

                break;
            case "Enoteca Sociale":
                TORONTO = new LatLng(43.649692, -79.425712);

                break;
            case "7 Numbers":
                TORONTO = new LatLng(43.676959, -79.353846);

                break;
            case "Donatello Restaurant":
                TORONTO = new LatLng(43.657317, -79.383479);

                break;
            case "KFC Eglinton":
                TORONTO = new LatLng(43.734623, -79.255756);

                break;
            case "McDoanl keel":
                TORONTO = new LatLng(43.672244, -79.467798);

                break;
        }
        return TORONTO;
    }
    public void initialize(LatLng place,String name) {
            //getSupportActionBar().setTitle(details);
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Marker Toronto = map.addMarker(new MarkerOptions().position(place).title(name));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 15));
        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);

    }

    public void edit(View view) {

       initialize(TORONTO,reasturant);
    }

    public void finish(View view) {
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        Marker Toronto = map.addMarker(new MarkerOptions().position(TORONTO).title(reasturant));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(TORONTO, 15));
        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);

    }
}
