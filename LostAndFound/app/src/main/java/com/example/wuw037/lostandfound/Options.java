package com.example.wuw037.lostandfound;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Options extends AppCompatActivity {

    public static final String PREFS_NAME = "Options";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        preferences = getSharedPreferences(PREFS_NAME, 0);
        editor = preferences.edit();

        Button found = (Button) findViewById(R.id.found);
        found.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FoundList.class);
                i.putExtra("Found", true);
                editor.putString("option", "0");
                editor.commit();
                startActivity(i);
                finish();

            }
        });

        Button lost = (Button) findViewById(R.id.lost);
        lost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LostList.class);
                i.putExtra("Found", false);
                editor.putString("option", "1");
                editor.commit();
                startActivity(i);
                finish();
            }
        });

        Button myposts = (Button) findViewById(R.id.mypost_button);
        myposts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MyPosts.class);
                editor.putString("option", "2");
                editor.commit();
                startActivity(i);
                finish();
            }
        });
    }

}
