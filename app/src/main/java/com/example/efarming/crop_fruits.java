package com.example.efarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.efarming.ui.marketing.MarketingFragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class crop_fruits extends AppCompatActivity {
    Spinner spFrtTyp, spFrtwgt;
    TextView mapLinkId, typFrt;
    Button BtnSubmit;
    EditText startId,endId;
    FirebaseAuth firebaseAuthdata;
    FirebaseFirestore firebaseFirestoredata;
    String userId1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_fruits);
        firebaseAuthdata = FirebaseAuth.getInstance();
        firebaseFirestoredata = FirebaseFirestore.getInstance();
        startId = (EditText)findViewById(R.id.startId);
        endId = (EditText)findViewById(R.id.endId);
        mapLinkId = (TextView) findViewById(R.id.mapLinkId);
        spFrtTyp = (Spinner) findViewById(R.id.spFrtTyp);
        spFrtwgt = (Spinner) findViewById(R.id.spFrtwgt);
        typFrt = (TextView) findViewById(R.id.typFrt);
        BtnSubmit = (Button)findViewById(R.id.BtnSubmit);
        typFrt.setText(MarketingFragment.x);
        spFrtTyp.setAdapter(MarketingFragment.adapter);
        ArrayList<String> spinItem1 = new ArrayList<>();
        spinItem1.add("Select");
        spinItem1.add("10 lbs");
        spinItem1.add("20 lbs");
        spinItem1.add("50 lbs");
        spinItem1.add("10 lbs");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinItem1);
        spFrtwgt.setAdapter(adapter1);
        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spFrtTyp.getSelectedItem().toString().equalsIgnoreCase("select")){
                    Toast.makeText(getApplicationContext(),"All fields must be filled",Toast.LENGTH_LONG).show();
                    return;
                }
                if (spFrtwgt.getSelectedItem().toString().equalsIgnoreCase("select")){
                    Toast.makeText(getApplicationContext(),"All fields must be filled",Toast.LENGTH_LONG).show();
                    return;
                }
                if (startId.getText().toString().length()==0 || endId.getText().toString().length()==0){
                    Toast.makeText(getApplicationContext(),"All fields must be filled",Toast.LENGTH_LONG).show();
                    return;
                }
                userId1 = firebaseAuthdata.getCurrentUser().getUid();
                Log.d("user id is : ","here id is "+userId1);
                if (userId1 == " "){
                    Toast.makeText(getApplicationContext(),"Please login to submit",Toast.LENGTH_LONG).show();
                    return;
                }
                DocumentReference documentReference1 = firebaseFirestoredata.collection("MarketingCropsData").document(userId1);
                Map<String,Object> user1 = new HashMap<>();
                user1.put("selected crop",spFrtTyp.getSelectedItem().toString());
                user1.put("weight in lbs",spFrtwgt.getSelectedItem().toString());
                user1.put("start range",Integer.parseInt(startId.getText().toString()));
                user1.put("end range",Integer.parseInt(endId.getText().toString()));
                documentReference1.set(user1).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG","user data created"+userId1);
                    }
                });
                Toast.makeText(getApplicationContext(),"Submitted successfully, we will get back with best deals through email",Toast.LENGTH_LONG).show();
            }
        });
        mapLinkId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(crop_fruits.this, SearchActivity.class);
                startActivity(intent1);
            }
        });
    }
}
