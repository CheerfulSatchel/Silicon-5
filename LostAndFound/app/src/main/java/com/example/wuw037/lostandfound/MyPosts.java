package com.example.wuw037.lostandfound;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuw037 on 6/7/17.
 */

public class MyPosts extends AppCompatActivity{

    public static final String PREFS_NAME = "Options";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    FirebaseAuth mAuth;
    ArrayList<Item> items;
    DatabaseReference myPostsRef;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_posts);

        mAuth = FirebaseAuth.getInstance();

        listView = (ListView) findViewById(R.id.my_post_list);

        items = new ArrayList<>();

        myPostsRef = FirebaseDatabase.getInstance().getReference("items/");
        myPostsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot d : dataSnapshot.getChildren()) {
                    Item item = d.getValue(Item.class);
                    System.out.println("PPPPPPP " + item.getName());
                    if(item.getUserID().equals(mAuth.getCurrentUser().getUid().toString()));
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

        //listView.setOnClickListener();
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
        finish();
    }



}
