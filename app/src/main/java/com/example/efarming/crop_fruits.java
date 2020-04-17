package com.example.efarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class crop_fruits extends AppCompatActivity {
    Spinner spFrtTyp,spFrtwgt;
    TextView mapLinkId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_fruits);
        mapLinkId = (TextView) findViewById(R.id.mapLinkId);
        spFrtTyp = (Spinner) findViewById(R.id.spFrtTyp);
        spFrtwgt = (Spinner) findViewById(R.id.spFrtwgt);
        ArrayList<String> spinItem = new ArrayList<>();
        spinItem.add("Select");
        spinItem.add("Grapes");
        spinItem.add("Apples");
        spinItem.add("Banana");
        spinItem.add("cherry");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spinItem);
        spFrtTyp.setAdapter(adapter);
        ArrayList<String> spinItem1 = new ArrayList<>();
        spinItem1.add("Select");
        spinItem1.add("10 lbs");
        spinItem1.add("20 lbs");
        spinItem1.add("50 lbs");
        spinItem1.add("10 lbs");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spinItem1);
        spFrtwgt.setAdapter(adapter1);
        mapLinkId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(crop_fruits.this,SearchActivity.class);
                startActivity(intent1);
            }
        });
    }
}
