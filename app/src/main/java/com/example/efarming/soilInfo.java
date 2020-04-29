package com.example.efarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class soilInfo extends AppCompatActivity {
    TextView soiltxtDisplay;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_info);
        soiltxtDisplay = (TextView) findViewById(R.id.soiltxtDisplay);
        Intent intent = getIntent();
        String x = intent.getStringExtra("soil_display_data");
        soiltxtDisplay.setText(x);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(soilInfo.this, Crop_Analysis_Inputform.class);
                startActivity(ini);
            }
        });
    }
}
