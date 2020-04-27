package com.example.efarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);
        String am = getIntent().getStringExtra("drop_down_amspt");
        String cname = getIntent().getStringExtra("drop_down_cname");
        String yrs = getIntent().getStringExtra("drop_down_yrs");
        String qn = getIntent().getStringExtra("drop_down_qn");
        String pr = getIntent().getStringExtra("drop_down_pr");
        EditText viewInfoTV = (EditText) findViewById(R.id.viewInfoTV);
        viewInfoTV.setText("Crop Name: "+cname+"\nYear Cultivated: "+yrs+"\nQuantity Cultivated: "+qn+"\nProfit obtained: "+pr
        +"\nAmount spent on Crop: "+am);
    }
}
