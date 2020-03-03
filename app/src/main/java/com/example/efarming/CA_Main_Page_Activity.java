package com.example.efarming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.efarming.R;

public class CA_Main_Page_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_crop_analysis);

        Button blackBTN = findViewById(R.id.BlackSoilBTN);
        Button redBTN = findViewById(R.id.RedSoilBTN);
        Button sandyBTN = findViewById(R.id.SandySoilBTN);

        blackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini1 = new Intent(CA_Main_Page_Activity.this, CA_RecucleView_Page_Activity.class);
                startActivity(ini1);
            }
        });

        redBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini1 = new Intent(CA_Main_Page_Activity.this, CA_RecucleView_Page_Activity.class);
                startActivity(ini1);
            }
        });

        sandyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini1 = new Intent(CA_Main_Page_Activity.this, CA_RecucleView_Page_Activity.class);
                startActivity(ini1);
            }
        });
    }
}
