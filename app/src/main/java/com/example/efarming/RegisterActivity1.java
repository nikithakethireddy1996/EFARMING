package com.example.efarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterActivity1 extends AppCompatActivity {
    Button registerBTN;
    TextView lnkLoginTV;
    EditText setFirstNameET,setLastNameET,setpasswordET,setemailET,setphoneET;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        registerBTN  = findViewById(R.id.registerBTN);
        setFirstNameET = findViewById(R.id.setFirstNameET);
        setLastNameET = findViewById(R.id.setLastNameET);
        setpasswordET = findViewById(R.id.setpasswordET);
        setemailET = findViewById(R.id.setemailET);
        setphoneET = findViewById(R.id.setphoneET);
        lnkLoginTV = findViewById(R.id.lnkLoginTV);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        registerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = setemailET.getText().toString().trim();
                String password  = setpasswordET.getText().toString().trim();
//                if (TextUtils.isEmpty(email)){
//                    setemailET.setError("email is req");
//                    return;
//                }
//                if (TextUtils.isEmpty(password)){
//                    setpasswordET.setError("password is req");
//                    return;
//                }
                if (setFirstNameET.length()==0 || setLastNameET.length()==0 || setpasswordET.length()==0
                || setemailET.length()==0 || setphoneET.length()==0){
                    Toast.makeText(getApplicationContext(),"All fields must be filled",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (setpasswordET.getText().toString().length()<8 &&!PasswordValidation(setpasswordET.getText().toString())){
                    Toast.makeText(getApplicationContext(),"password must contain minimum 8 characters with at least" +
                            "1 Alphabet,1 Number and 1 special character",Toast.LENGTH_LONG).show();
                    return;
                }
                if (!isEmailValid(setemailET.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Email address should be of valid format",Toast.LENGTH_LONG).show();
                    return;
                }
                if (!isValidphone(setphoneET.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Phone number should be of valid format",Toast.LENGTH_LONG).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"Registered Successfully!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity1.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(RegisterActivity1.this,"could not register",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        lnkLoginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity1.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public static boolean PasswordValidation(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isEmailValid(final String email) {
        final String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    private boolean isValidphone(String bphone) {
        return !TextUtils.isEmpty(bphone) &&
                bphone.length() == 10 &&
                TextUtils.isDigitsOnly(bphone);
    }


}


