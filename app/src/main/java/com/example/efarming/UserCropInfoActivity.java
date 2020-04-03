package com.example.efarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserCropInfoActivity extends AppCompatActivity {
    private Button button1;
    EditText setCropNameET;
    EditText setYearCultivatedET;
    EditText setQuantityCultivatedET;
    EditText setProfitObtainedET;
    EditText setAmountSpendET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_crop_info);
        setCropNameET = (EditText) findViewById(R.id.setCropNameET);
        setYearCultivatedET = (EditText) findViewById(R.id.setYearCultivatedET);
        setQuantityCultivatedET=(EditText) findViewById(R.id.setQuantityCultivatedET);
        setProfitObtainedET=(EditText)findViewById(R.id.setProfitObtainedET);
        setAmountSpendET=(EditText)findViewById(R.id.setAmountSpendET);
        button1 = (Button) findViewById(R.id.saveBTN);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if (setCropNameET.length()!=0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_SHORT);
                    toast.show();
                }*/

                if (setCropNameET.length()==0 ||  setQuantityCultivatedET.length()==0
                        || setProfitObtainedET.length()==0 || setAmountSpendET.length()==0){
                    Toast.makeText(getApplicationContext(),"All the required fields must be filled",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent in = new Intent(UserCropInfoActivity.this, MainActivity.class);
                startActivity(in);
            }
        });
    }


//    protected void onStop() {
//        super.onStop();
//        Toast toast = Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_SHORT);
//        View view = toast.getView();
//        view.setBackgroundColor(Color.BLACK);
//        TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
//        toastMessage.setTextColor(Color.WHITE);
//        toast.show();
//    }
}

