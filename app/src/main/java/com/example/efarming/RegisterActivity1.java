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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                if (setpasswordET.getText().toString().length()<8 &&!PasswordValidation(setpasswordET.getText().toString())){
                    Toast.makeText(getApplicationContext(),"password must contain minimum 8 characters with at least" +
                            "1 Alphabet,1 Number and 1 special character",Toast.LENGTH_LONG).show();
                    return;
                }
                if (!isEmailValid(setemailET.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Email address should be of valid format",Toast.LENGTH_LONG).show();
                    return;
                }
                Toast toast = Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT);
                TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                toastMessage.setTextColor(Color.BLACK);
                toast.show();
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


    private void moveToMainActivity() {
        Intent in = new Intent(RegisterActivity1.this, MainActivity.class);
        startActivity(in);
    }

//    protected void onStop() {
//        super.onStop();
//        Toast toast = Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT);
//        View view = toast.getView();
//        view.setBackgroundColor(Color.BLACK);
//        TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
//        toastMessage.setTextColor(Color.WHITE);
//        toast.show();
//    }

}


