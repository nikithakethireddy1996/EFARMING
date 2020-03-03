package com.example.efarming;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.efarming.R;

public class CA_RecucleView_Page_Activity extends AppCompatActivity {
    private com.example.efarming.Crop_Analysis_Adapter cpAdapter = null;
    private RecyclerView cpRV = null;
    private GestureDetectorCompat detector = null;


    private class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            View view = cpRV.findChildViewUnder(e.getX(), e.getY());
            if (view != null) {
                RecyclerView.ViewHolder holder = cpRV.getChildViewHolder(view);
                if (holder instanceof com.example.efarming.Crop_Analysis_Adapter.CPViewHolder) {
                    int position = holder.getAdapterPosition();
                    com.example.efarming.Crop_Analysis_Model cpModel = Crop_Analysis_Model.getCrop_protection();
                    cpAdapter.notifyItemRemoved(position);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_analysis_recycleview_page);


        Button addBTN = findViewById(R.id.addBTN);
        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(CA_RecucleView_Page_Activity.this, Crop_Analysis_Inputform.class);
                startActivity(ini);
            }
        });
        cpAdapter = new Crop_Analysis_Adapter();
        cpRV = findViewById(R.id.cpRV);
        cpRV.setAdapter(cpAdapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        cpRV.setLayoutManager(manager);
    }
}
