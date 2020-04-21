package com.example.efarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;


public class LoginActivity extends AppCompatActivity {
    private Button loginBTN;
    private EditText userNameET;
    private EditText passwordET;
    public static String userName, emailId = "";
    public static boolean isUserLogin = false;
    FirebaseAuth fAuth;
    FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameET = (EditText) findViewById(R.id.userNameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        loginBTN = (Button) findViewById(R.id.loginBTN);
        fAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
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
                final String email = userNameET.getText().toString();
                String password = passwordET.getText().toString();
                if (userNameET.length() == 0) {
                    Toast.makeText(getApplicationContext(), "username must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passwordET.length() == 0) {
                    Toast.makeText(getApplicationContext(), "password must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            isUserLogin = true;
                            getUserName(email);
                            emailId = email;
                            Toast.makeText(getApplicationContext(), "Logged in Successfully!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Entered Email or password does not match", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
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

    public void getUserName(final String email) {

        firebaseFirestore.collection("usersList").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e != null) {
                    Log.d("LoginActivity", "Error:" + e.getMessage());
                    return;
                } else {
                    for (DocumentChange documentChange : documentSnapshots.getDocumentChanges()) {
                        if (email.equalsIgnoreCase(documentChange.getDocument().getData().get("EmailId").toString())) {
                            userName = documentChange.getDocument().getData().get("FirstName").toString();
                            userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            break;
                        }
                    }
                }
            }
        });
    }

}
