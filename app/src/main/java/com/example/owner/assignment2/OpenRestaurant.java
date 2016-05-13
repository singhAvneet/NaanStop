package com.example.owner.assignment2;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.owner.assignment2.R.layout.fragment2;

/**
 * Created by Owner on 2015-09-23.
 */
public class OpenRestaurant extends Activity {
    public static String str;
    public static int counter;
    public static String[] dishes=new String[5];


    //validation
    private Pattern Name_pattern,Credit_pattern;
    private Matcher Name_matcher,Credit_matcher;
    final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    final String regexName = "^[A-Za-z]*$";
    final String regexCredit = "[0-9]{4}";


    static Intent intent;
    public static GoogleMap map ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retaurant);

    }




    public void onClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        LinearLayout ll = new LinearLayout(this);
        RadioGroup rg=(RadioGroup) findViewById(R.id.radiogroup);
        String[] Reastaurant = new String[9];// getResources().getStringArray(R.array.italianReastaurant);
                // Check which radio button wa clicked
        switch (view.getId()) {
            case R.id.intalian:
                if (checked) {
                    Reastaurant = getResources().getStringArray(R.array.italianReastaurant);
                    openReastaurantList(3, Reastaurant, ll, rg,"Intalian");
                            }
               break;
            case R.id.indian:

                if (checked)
                    Reastaurant =getResources().getStringArray(R.array.indianReastaurant);
                openReastaurantList(3,Reastaurant,ll,rg,"Indian");

                break;
            case R.id.chinese:
                if (checked)
                    Reastaurant = getResources().getStringArray(R.array.chineseReastaurant);
                openReastaurantList(4,Reastaurant,ll,rg,"Chinese");
                break;

            case R.id.fastFood:
                if (checked)
                    Reastaurant = getResources().getStringArray(R.array.fastFoodReastaurant);
                openReastaurantList(2,Reastaurant,ll,rg,"Fast Food");
                break;
        }

    }

    private void openReastaurantList(int n,String[] ListReastaurant,LinearLayout ll,RadioGroup rg,String name) {
        TextView data=(TextView)findViewById(R.id.data);
        data.setText("List of " + name + " Reastaurant");
        final Spinner spinnerCountShoes =(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerCountShoesArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, ListReastaurant);
        spinnerCountShoes.setAdapter(spinnerCountShoesArrayAdapter);

        spinnerCountShoes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {


                str = spinnerCountShoes.getItemAtPosition(pos).toString();
                mapRest(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
    }
public void showMap(String name,Double lat,Double lng){

    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.Fragmnetmap)).getMap();
    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);//MAP_TYPE_SATELLITE
    Marker Toronto = map.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title(name));
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 15));
    map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);



}
    public void mapRest(String str) {

        switch (str) {
            case "Banjara Indian":
                showMap(str, 43.663160, -79.421923);
                break;
            case "Little Indian":
                showMap(str,43.650236,-79.388956);
                break;
            case "Lahore Tikka":
                showMap(str, 43.672085, -79.322086);
                break;
            case "Swatow Restaurant":
                showMap(str, 43.653836,-79.398109);
                break;
            case "Bamboo Buddha":
                showMap(str, 43.643529,-79.405104);
                break;
            case "Szechuan Express":
                showMap(str, 43.648636,-79.381744);
                break;
            case "Lai Wah Heen":
                showMap(str, 43.654671,-79.386172);
                break;
            case "Enoteca Sociale":
                showMap(str, 43.649692,-79.425712);
                break;
            case "7 Numbers":
                showMap(str, 43.676959,-79.353846);
                break;
            case "Donatello Restaurant":
                showMap(str, 43.657317,-79.383479);
                break;
            case "KFC Eglinton":
                showMap(str, 43.734623,-79.255756);
                break;
            case "McDoanl keel":
                showMap(str, 43.672244,-79.467798);
                break;

        }
    }




    public void dishes(View view) {
        String[] arrayIndian_1=getResources().getStringArray(R.array.indian_1);
        String[] arrayIndian_2=getResources().getStringArray(R.array.indian_2);
        String[] arrayIndian_3=getResources().getStringArray(R.array.indian_3);
        String[] arrayChinese_1=getResources().getStringArray(R.array.Chinese_1);
        String[] arrayChinese_2=getResources().getStringArray(R.array.Chinese_2);
        String[] arrayChinese_3=getResources().getStringArray(R.array.Chinese_3);
        String[] arrayChinese_4=getResources().getStringArray(R.array.Chinese_4);
        String[] arrayItalian_1=getResources().getStringArray(R.array.Italian_1);
        String[] arrayItalian_2=getResources().getStringArray(R.array.Italian_2);
        String[] arrayItalian_3=getResources().getStringArray(R.array.Italian_3);
        String[] arrayKFC=getResources().getStringArray(R.array.KFC);
        String[] arrayMcdonal=getResources().getStringArray(R.array.McDoanl);
str1="";
    switch (str){
        case "Banjara Indian":
            showListOFDishes(3,arrayIndian_1);
            break;
        case "Little Indian":
            showListOFDishes(2, arrayIndian_2);
            break;
        case "Lahore Tikka":
            showListOFDishes(3,arrayIndian_3);
            break;
        case "Swatow Restaurant":
            showListOFDishes(4,arrayChinese_1);
            break;
        case "Bamboo Buddha":
            showListOFDishes(2,arrayChinese_2);
            break;
        case "Szechuan Express":
            showListOFDishes(3,arrayChinese_3);
            break;
        case "Lai Wah Heen":
            showListOFDishes(3,arrayChinese_4);
            break;
        case "Enoteca Sociale":
            showListOFDishes(4,arrayItalian_1);
            break;
        case "7 Numbers":
            showListOFDishes(3,arrayItalian_2);
            break;
        case "Donatello Restaurant":
            showListOFDishes(3,arrayItalian_3);
            break;
        case "KFC Eglinton":
            showListOFDishes(2,arrayKFC);
            break;
        case "McDoanl keel":
            showListOFDishes(2, arrayMcdonal);
            break;

    }


    }
    CheckBox[] box=new CheckBox[9];
    private void showListOFDishes( int n,String[] arrayList) {
        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        ScrollView sv1=(ScrollView)findViewById(R.id.sv);
        ScrollView sv=new ScrollView(this);
        sv.addView(ll);

        for(int i=0;i<n;i++){
            box[i] = new CheckBox(this);
            box[i].setId(i * 2);
            box[i].setText(arrayList[i]);
            ll.addView(box[i]);
        }
        setContentView(sv);
        counter=n;

        Button back=new Button(this);
        back.setText("Back");
        ll.addView(back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < counter; i++) {
                    boolean check = box[i].isChecked();
                    if (check)
                        dishes[i] = box[i].getText().toString(); //((CheckBox) view).getText().toString();
                    else
                        dishes[i] = null;
                }
                Intent back = new Intent(getApplicationContext(), OpenRestaurant.class);
                startActivity(back);
            }
        });
    }
    public static String str1 = "";

    public void data(View view) {
         EditText name=(EditText)findViewById(R.id.editName);
         EditText credit=(EditText)findViewById(R.id.editCredit);
         EditText brand=(EditText)findViewById(R.id.editBrand);
         EditText email=(EditText)findViewById(R.id.editEmail);
          EditText place=(EditText)findViewById(R.id.editFravouritePlace);
        String strName = name.getText().toString();
        String strEmail = email.getText().toString();
        String strBrand = brand.getText().toString();
        String strCredit = credit.getText().toString();
        String strPlace = place.getText().toString();
str1="";
        for(int i=0;i<counter;i++) {
            if(dishes[i]!=null)
                str1 =dishes[i]+" \n\t\t                      "+  str1 ;
        }
        CustomerDetails obj=new CustomerDetails(strName,strPlace,strBrand,strEmail,strCredit,str1);
        Intent inetent=new Intent(this,OrderInformation.class);
        inetent.putExtra("Finalkey",
                "Your Order:     "+obj.getOrder()+"\n\n"+
                "Your Name:      "+ obj.getname()+"\n\n"+
                "Email:          "+ obj.getEmail()+"\n\n"+
                "Credit Card:    "+ obj.getCredite()+"\n\n"+
                "Favourite Place:"+obj.getPlace()+"\n\n"+
                "Favourite Brand:"+obj.getBrand()    );
inetent.putExtra("restKey",str);

       //validation part
        Name_pattern = Pattern.compile(regexName);
        Name_matcher = Name_pattern.matcher(strName);
        Credit_pattern=Pattern.compile(regexCredit);
        Credit_matcher=Credit_pattern.matcher(strCredit);
        if( !Name_matcher.matches()) {
            name.setError("Pl put valid name!");
        }
        else if (!Credit_matcher.matches()){
credit.setError("Pl put valid 16 digit number");
                    }
        else {
            startActivity(inetent);

        }


    }
}




