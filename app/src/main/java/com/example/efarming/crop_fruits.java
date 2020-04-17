package com.example.efarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.efarming.ui.marketing.MarketingFragment;

import java.util.ArrayList;

public class crop_fruits extends AppCompatActivity {
    Spinner spFrtTyp, spFrtwgt;
    TextView mapLinkId, typFrt;
    Button BtnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_fruits);
        mapLinkId = (TextView) findViewById(R.id.mapLinkId);
        spFrtTyp = (Spinner) findViewById(R.id.spFrtTyp);
        spFrtwgt = (Spinner) findViewById(R.id.spFrtwgt);
        typFrt = (TextView) findViewById(R.id.typFrt);
        BtnSubmit = (Button)findViewById(R.id.BtnSubmit);
        typFrt.setText(MarketingFragment.x);
        spFrtTyp.setAdapter(MarketingFragment.adapter);
        ArrayList<String> spinItem1 = new ArrayList<>();
        spinItem1.add("Select");
        spinItem1.add("10 lbs");
        spinItem1.add("20 lbs");
        spinItem1.add("50 lbs");
        spinItem1.add("10 lbs");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinItem1);
        spFrtwgt.setAdapter(adapter1);
        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Submitted successfully, we will get back with best deals through email",Toast.LENGTH_LONG).show();
            }
        });
        mapLinkId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(crop_fruits.this, SearchActivity.class);
                startActivity(intent1);
            }
        });
    }
}
