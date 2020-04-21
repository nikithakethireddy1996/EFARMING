package com.example.efarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.HashMap;
import java.util.Map;


public class UserCropInfoActivity extends AppCompatActivity {
    private Button button1;
    EditText setCropNameET;
    EditText setYearCultivatedET;
    EditText setQuantityCultivatedET;
    EditText setProfitObtainedET;
    EditText setAmountSpendET;

    private FirebaseFirestore db;

   /* FirebaseAuth mAuth;
    String userId;
    FirebaseFirestore firebaseFirestore;*/


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

        db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().setTimestampsInSnapshotsEnabled(true).build();
        db.setFirestoreSettings(settings);


        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String name = setCropNameET.getText().toString().trim();
                String year = setYearCultivatedET.getText().toString().trim();
                String quantity = setQuantityCultivatedET.getText().toString().trim();
                String profit = setProfitObtainedET.getText().toString().trim();
                String amount = setAmountSpendET.getText().toString().trim();

               /* if (setCropNameET.length()!=0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_SHORT);
                    toast.show();
                }*/

                if (setCropNameET.length() == 0 || setQuantityCultivatedET.length() == 0
                        || setProfitObtainedET.length() == 0 || setAmountSpendET.length() == 0) {
                    Toast.makeText(getApplicationContext(), "All the required fields must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }

                //  DocumentReference documentReference = firebaseFirestore.collection("crops").document(userId);
                Map<String, Object> crop = new HashMap<>();
                crop.put("Name", name);
                crop.put("Year", year);
                crop.put("Quantity", quantity);
                crop.put("Profit", profit);
                crop.put("Amount spent", amount);
                db.collection("cropsInfo").add(crop)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("addCropsActivity", "DocumentSnapshot added with ID: " + documentReference.getId());
                                setCropNameET.setText("");
                                setYearCultivatedET.setText("");
                                setQuantityCultivatedET.setText("");
                                setProfitObtainedET.setText("");
                                setAmountSpendET.setText("");

                            }
                });

                                Toast toast = Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_SHORT);
                                TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                                toastMessage.setTextColor(Color.BLACK);
                                toast.show();

                                Intent in = new Intent(UserCropInfoActivity.this, MainActivity.class);
                                startActivity(in);
                            }
                        });
            }

        }

