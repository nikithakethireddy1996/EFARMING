package com.example.efarming;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.efarming.R;

public class Crop_Analysis_Inputform extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop__analysis__inputform);

        final Crop_Analysis_Model soil = new Crop_Analysis_Model();
        final EditText nameET = findViewById(R.id.nameET);
        final EditText titleET = findViewById(R.id.titleET);
        final EditText cropET = findViewById(R.id.cropET);
        final EditText temperatureET = findViewById(R.id.temperatureET);
        final EditText commentET = findViewById(R.id.commentET);
        Button saveBTN = findViewById(R.id.saveBTN);

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.toString();
                String title = titleET.toString();
                String crop = cropET.toString();
                double temperature = Double.parseDouble(temperatureET.toString());
                String comment = commentET.toString();

                soil.addBlackSoil(name, title, crop, temperature, comment);
            }
        });
    }
}
