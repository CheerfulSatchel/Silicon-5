package com.example.wuw037.lostandfound;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemListAdapter extends ArrayAdapter<Item>{

    private final Context context;
    private final ArrayList<Item> items;

    public ItemListAdapter(Context context, ArrayList<Item> items){
        super(context, -1, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item, parent, false);

        TextView nameView = (TextView) rowView.findViewById(R.id.name);
        TextView bountyView = (TextView) rowView.findViewById(R.id.bounty);
        TextView locationView = (TextView) rowView.findViewById(R.id.location);

        nameView.setText(items.get(position).getName());
        bountyView.setText( Integer.toString(items.get(position).getBounty()));
//        locationView.setText(items.get(position).)

        return rowView;

    }


}