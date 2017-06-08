package com.example.wuw037.lostandfound;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by zfe963 on 6/8/17.
 */

public class ItemDetails extends AppCompatActivity {

    private TextView nameView;
    private TextView descriptionView;
    private TextView telephoneView;
    private TextView timeView;
    private TextView bountyView;
    private TextView locationView;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        nameView = (TextView) findViewById(R.id.textView);
        descriptionView = (TextView) findViewById(R.id.textView6);
        telephoneView = (TextView) findViewById(R.id.textView7);
        timeView = (TextView) findViewById(R.id.textView4);
        bountyView = (TextView) findViewById(R.id.textView8);
        locationView = (TextView) findViewById(R.id.textView3);


        Bundle extras = getIntent().getExtras();
        String name = (String) extras.get("name");
        String description = (String) extras.get("description");
        String location = (String) extras.get("location");
        String telephone = (String) extras.get("telephone");
        String time = (String) extras.get("time");
        String bounty = (String) extras.get("bounty");

        boolean found = extras.getBoolean("found");
        if(found){
            bountyView.setText("Bounty: N/A");
        }
        else{
            bountyView.setText("Bounty: " + bounty);
        }

        locationView.setText("Location: " + location);
        telephoneView.setText("Telephone: " + telephone);
        timeView.setText("Time: " + time);
        nameView.setText("Name: " + name);
        descriptionView.setText("Description: " + description);

    }

}
