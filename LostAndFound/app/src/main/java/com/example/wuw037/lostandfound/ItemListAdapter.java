package com.example.wuw037.lostandfound;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ItemListAdapter extends ArrayAdapter<Item>{

    public static final String PREFS_NAME = "Options";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    private final Context context;
    private final ArrayList<Item> items;

    DatabaseReference myPostsRef;


    public ItemListAdapter(Context context, ArrayList<Item> items){
        super(context, -1, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item, parent, false);

        TextView nameView = (TextView) rowView.findViewById(R.id.name);
        TextView bountyView = (TextView) rowView.findViewById(R.id.bounty);
        TextView locationView = (TextView) rowView.findViewById(R.id.location);

        final int pos = position;
        final Context tempContext = this.context;

        nameView.setText(items.get(position).getName());
        bountyView.setText("$" + Integer.toString(items.get(position).getBounty()));

//        //if the item is lost post the bounty, otherwise don't
//        if(!items.get(position).isFound())
//            bountyView.setText( Integer.toString(items.get(position).getBounty()));
        locationView.setText(items.get(position).getLocation());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences = getContext().getSharedPreferences(PREFS_NAME, 0);
                String optionVal = preferences.getString("option", "none");
                myPostsRef = FirebaseDatabase.getInstance().getReference("items/");

                // Found
                if(optionVal.equals("0")) {

                }
                // Lost
                else if(optionVal.equals("1")) {

                }
                //My Posts
                else if(optionVal.equals("2")) {

                    // Delete item from Firebase
                    myPostsRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot d : dataSnapshot.getChildren()) {
                                Item item = d.getValue(Item.class);
                                if(items.get(pos).compareTo(item) == 0) {
                                    System.out.println("YYYYYY: " + d.getKey().toString());
                                    myPostsRef.child(d.getKey()).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }

                }
        });

        return rowView;

    }

}