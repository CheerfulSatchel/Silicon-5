package com.example.wuw037.lostandfound;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LostList extends AppCompatActivity {

    ArrayList<Item> items;
    RecyclerView rvLostItems;

    ListView listView;
    DatabaseReference lostItemsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_list);

        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.add_lost_item);
        addButton.bringToFront();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LostForm.class);
                startActivity(intent);
                finish();
            }
        });

        listView = (ListView) findViewById(R.id.lost_list);
        items = new ArrayList<>();

        lostItemsRef = FirebaseDatabase.getInstance().getReference("items/");
        lostItemsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot d : dataSnapshot.getChildren()) {
                    Item item = d.getValue(Item.class);
                    System.out.println("PPPPPPP " + item.getName());
                    if(!item.isFound())
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
