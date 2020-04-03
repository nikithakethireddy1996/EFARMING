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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {
    private Button button2;
    EditText EmailTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        button2 = (Button) findViewById(R.id.backBTN);
        EmailTxt = (EditText) findViewById(R.id.EmailTxt);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmailValid(EmailTxt.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Email address should be of valid format",Toast.LENGTH_LONG).show();
                    return;
                }
                moveToLoginActivity();
            }
        });
    }

    private void moveToLoginActivity() {
        Intent in = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
        startActivity(in);
    }

    public static boolean isEmailValid(final String email) {
        final String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    protected void onStop() {
        super.onStop();
        Toast toast = Toast.makeText(getApplicationContext(), "Reset Link sent ", Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundColor(Color.BLACK);
        TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
        toastMessage.setTextColor(Color.WHITE);
        toast.show();

    }
}
