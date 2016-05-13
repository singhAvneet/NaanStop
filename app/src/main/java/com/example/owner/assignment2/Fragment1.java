package com.example.owner.assignment2;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Owner on 2015-09-23.
 */
public class Fragment1 extends Fragment {
   // public  static  MapActivity mapRest=new MapActivity();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

     //
        return inflater.inflate(R.layout.fragment1, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
 RadioButton type1 = (RadioButton) getActivity().findViewById(R.id.intalian);

        RadioButton type2 = (RadioButton) getActivity().findViewById(R.id.indian);
        RadioButton type3 = (RadioButton) getActivity().findViewById(R.id.chinese);
        RadioButton type4 = (RadioButton) getActivity().findViewById(R.id.fastFood);
        String[] type = getResources().getStringArray(R.array.foodType);

        type1.setText(type[0]);
        type2.setText(type[1]);
        type3.setText(type[2]);
        type4.setText(type[3]);


    }





}