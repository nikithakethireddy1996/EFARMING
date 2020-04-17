package com.example.efarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {
    ProgressBar progressBar1;
    Button backBTN;
    EditText EmailTxt;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        backBTN = (Button) findViewById(R.id.backBTN);
        EmailTxt = (EditText) findViewById(R.id.EmailTxt);
        progressBar1 = findViewById(R.id.progressBar1);
        firebaseAuth = FirebaseAuth.getInstance();
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!isEmailValid(EmailTxt.getText().toString())){
//                    Toast.makeText(ForgotPasswordActivity.this,"please enter valid email Id",Toast.LENGTH_SHORT).show();
//                }
                progressBar1.setVisibility(View.VISIBLE);
                firebaseAuth.sendPasswordResetEmail(EmailTxt.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ForgotPasswordActivity.this,"reset link sent to your registered email",Toast.LENGTH_SHORT).show();
                            progressBar1.setVisibility(View.GONE);
                            Intent intent2 = new Intent(ForgotPasswordActivity.this,LoginActivity.class);
                            startActivity(intent2);
                        }
                        else {
                            Toast.makeText(ForgotPasswordActivity.this,"entered email is not registered",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }


//    public static boolean isEmailValid(final String email) {
//        final String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
//        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }

}
