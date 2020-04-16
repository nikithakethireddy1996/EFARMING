package com.example.efarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private Button loginBTN;
    private EditText userNameET;
    private EditText passwordET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        userNameET = (EditText)findViewById(R.id.userNameET);
        passwordET = (EditText)findViewById(R.id.passwordET);
        loginBTN = (Button)findViewById(R.id.loginBTN);
        TextView register = (TextView) findViewById(R.id.lnkRegisterTV);
        register.setMovementMethod(LinkMovementMethod.getInstance());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity1.class);
                startActivity(intent);
            }
        });

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userNameET.length()==0){
                    Toast.makeText(getApplicationContext(),"username must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passwordET.length()==0){
                    Toast.makeText(getApplicationContext(),"password must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userNameET.getText().toString().equals("efarming@gmail.com")
                        && passwordET.getText().toString().equals("farm@1234")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else if (!(userNameET.getText().toString().equals("efarming@gmail.com")
                        && passwordET.getText().toString().equals("farm@1234")))
                Toast.makeText(getApplicationContext(),"username or password is incorrect", Toast.LENGTH_SHORT).show();
            }
        });

        TextView forgotpassword = (TextView) findViewById(R.id.lnkForgotpasswordTV);
        forgotpassword.setMovementMethod(LinkMovementMethod.getInstance());
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent1);
            }
        });
    }

}
