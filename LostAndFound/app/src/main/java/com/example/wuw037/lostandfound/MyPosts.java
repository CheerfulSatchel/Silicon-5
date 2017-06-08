package com.example.wuw037.lostandfound;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by wuw037 on 6/7/17.
 */

public class MyPosts extends AppCompatActivity{

    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_posts);

        ListView listView = (ListView) findViewById(R.id.my_post_list);
        Item item1 = new Item("wallet", 300);
        Item item2 = new Item("purse", 200);
        Item item3 = new Item("car", 5000);

        items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        ItemListAdapter adapter = new ItemListAdapter(this, items);
        listView.setAdapter(adapter);

    }

}
