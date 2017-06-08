package com.example.wuw037.lostandfound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class LostList extends AppCompatActivity {

    ArrayList<Item> items;
    RecyclerView rvLostItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_list);

/*
        //find the recycler view
        rvLostItems = (RecyclerView) findViewById(R.id.rvLostItems);
        items = new ArrayList<>();

        //initialize sample items
        for(int i = 0; i < 3; i++){
            items.add(new Item("Item" + i, i*100));
        }

        //create adapter with sample data
        ItemListAdapter adapter = new ItemListAdapter(this, items);

        //attach adapter to recycler view to populate
        rvLostItems.setAdapter(adapter);

        rvLostItems.setLayoutManager(new LinearLayoutManager(this));
*/

        ListView listView = (ListView) findViewById(R.id.lost_list);
        Item item1 = new Item("wallet", 300);
        Item item2 = new Item("purse", 200);
        Item item3 = new Item("car", 5000);

        items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        ItemListAdapter adapter = new ItemListAdapter(this, items);
        listView.setAdapter(adapter);


        /*
        // Needs to be populated
        List<String> lostList = new ArrayList<String>();

        lv = (ListView)findViewById(R.id.lostlist);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_checked,
                lostList);

        lv.setAdapter(arrayAdapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        */
    }

}
