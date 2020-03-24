package com.example.efarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity1 extends AppCompatActivity {
    private Button registerBTN;
    EditText setFirstNameET,setLastNameET,setpasswordET,setemailET,setphoneET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        //Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
        registerBTN = (Button) findViewById(R.id.registerBTN);
        setFirstNameET = (EditText)findViewById(R.id.setFirstNameET);
        setLastNameET = (EditText)findViewById(R.id.setLastNameET);
        setpasswordET = (EditText)findViewById(R.id.setpasswordET);
        setemailET = (EditText)findViewById(R.id.setemailET);
        setphoneET = (EditText)findViewById(R.id.setphoneET);
        registerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setFirstNameET.length()==0 || setLastNameET.length()==0 || setpasswordET.length()==0
                || setemailET.length()==0 || setphoneET.length()==0){
                    Toast.makeText(getApplicationContext(),"All fields must be filled",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(RegisterActivity1.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        TextView login = (TextView) findViewById(R.id.lnkLoginTV);
        login.setMovementMethod(LinkMovementMethod.getInstance());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity1.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void moveToMainActivity() {
        Intent in = new Intent(RegisterActivity1.this, MainActivity.class);
        startActivity(in);
    }

    protected void onStop() {
        super.onStop();
        Toast toast = Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT);
//        View view = toast.getView();
//        view.setBackgroundColor(Color.BLACK);
        TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
        toastMessage.setTextColor(Color.WHITE);
        toast.show();
    }

}


