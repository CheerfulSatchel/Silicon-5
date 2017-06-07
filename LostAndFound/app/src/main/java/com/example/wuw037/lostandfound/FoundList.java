package com.example.wuw037.lostandfound;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class FoundList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_list);

        Button report_lost_item = (Button) findViewById(R.id.report_lost_item);
        report_lost_item.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LostForm.class);
                startActivity(i);
            }
        });
    }

}
