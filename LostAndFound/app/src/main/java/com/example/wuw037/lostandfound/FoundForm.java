package com.example.wuw037.lostandfound;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class FoundForm extends AppCompatActivity implements LocationListener {

    FirebaseAuth mAuth;
    DatabaseReference mRef;

    double longitude, latitude;
    LocationManager locationManager;
    EditText item, description;
    private static final int TAKE_PHOTO_PERMISSION = 1;
    String city, state;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_form);

        item = (EditText) findViewById(R.id.found_item);
        description = (EditText) findViewById(R.id.found_description);


        mAuth = FirebaseAuth.getInstance();

        city = "";
        state = "";
        time = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        Toast.makeText(this, "Time: " + time, Toast.LENGTH_LONG).show();

        // Here is the code to handle permissions - you should not need to edit this.
        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION }, TAKE_PHOTO_PERMISSION);
        }

        try {
            // Add code here to register the listener with the Location Manager to receive location updates
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        }
        catch(SecurityException e) {
            Log.e("Error!", e.getMessage());
        }

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @Override
    public void onLocationChanged(Location location) {
        // Add code here to do stuff when the location changes
        longitude = location.getLongitude();
        latitude = location.getLatitude();

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses;

        city = "";
        state = "";

        try {
            addresses = geocoder.getFromLocation(longitude, latitude, 4);
            city = addresses.get(0).getLocality();
            state = addresses.get(0).getAdminArea();


            if(city == null || city.equals("")) {
                city = "Richmond";
            }
            if(state == null || state.equals("")){
                state = "VA";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

//        Toast.makeText(this, "BEFORE: City: " + city + ", State: " + state, Toast.LENGTH_SHORT).show();
        locationManager.removeUpdates(this);
//        Toast.makeText(this, "AFTER: City: " + city + ", State: " + state, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {}

    @Override
    public void onProviderEnabled(String s) {}

    @Override
    public void onProviderDisabled(String s) {}

    public void SubmitFoundForm(View v) {

        mRef = FirebaseDatabase.getInstance().getReference("items");

        String nItem = item.getText().toString();
        String nDescription = description.getText().toString();
        Item newItem = new Item(nItem, city + ", " + state, nDescription, time, 0, true);

        mRef.push().setValue(newItem);

        Intent intent = new Intent(this, FoundList.class);

        startActivity(intent);
        finish();
    }




}
