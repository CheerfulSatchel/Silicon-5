package com.example.wuw037.lostandfound;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Options extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


        Button found = (Button) findViewById(R.id.found);
        found.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FoundList.class);
                startActivity(i);

            }
        });

        Button lost = (Button) findViewById(R.id.lost);
        lost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LostList.class);
                startActivity(i);
            }
        });

        Button myposts = (Button) findViewById(R.id.mypost_button);
        myposts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MyPosts.class);
                startActivity(i);
            }
        });
    }

}
