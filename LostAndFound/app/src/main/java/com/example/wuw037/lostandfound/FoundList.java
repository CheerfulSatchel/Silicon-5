package com.example.wuw037.lostandfound;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by wuw037 on 6/7/17.
 */

public class FoundList extends AppCompatActivity{

    ArrayList<Item> items;

    ListView listView;
    DatabaseReference foundItemsRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_list);

        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.add_found_list);
        addButton.bringToFront();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FoundForm.class);
                startActivity(intent);
                finish();
            }
        });

        listView = (ListView) findViewById(R.id.found_list);
        items = new ArrayList<>();

        foundItemsRef = FirebaseDatabase.getInstance().getReference("items/");
        foundItemsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot d : dataSnapshot.getChildren()) {
                    Item item = d.getValue(Item.class);
                    System.out.println("PPPPPPP " + item.getName());
                    if(item.isFound())
                        items.add(item);
                }
                ItemListAdapter adapter = new ItemListAdapter(getApplicationContext(), items);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ItemListAdapter adapter = new ItemListAdapter(this, items);
        listView.setAdapter(adapter);

    }

    public void onBackPressed() {
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
        finish();
    }

}
