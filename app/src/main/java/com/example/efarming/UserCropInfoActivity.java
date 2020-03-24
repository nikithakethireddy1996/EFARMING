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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_crop_info);
        setCropNameET = (EditText) findViewById(R.id.setCropNameET);
        button1 = (Button) findViewById(R.id.saveBTN);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setCropNameET.length()!=0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_SHORT);
                    toast.show();
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

