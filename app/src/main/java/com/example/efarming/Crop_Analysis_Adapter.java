package com.example.efarming;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.efarming.R;

public class Crop_Analysis_Adapter extends RecyclerView.Adapter<Crop_Analysis_Adapter.CPViewHolder>{
    com.example.efarming.Crop_Analysis_Model crop_protection;

    public Crop_Analysis_Adapter(){
        super();
        crop_protection = com.example.efarming.Crop_Analysis_Model.getCrop_protection();
    }

    public static class CPViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout lnr;
        public CPViewHolder(LinearLayout lnrLayout){
            super(lnrLayout);
            lnr = lnrLayout;
        }
    }

    @NonNull
    @Override
    public CPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ca_recycleview_layout, parent, false);
        CPViewHolder cpViewHolder = new CPViewHolder(linearLayout);
        return cpViewHolder;
    }

    @Override
    public int getItemCount(){
        return crop_protection.black.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CPViewHolder holder, int position){
        TextView textView = holder.lnr.findViewById(R.id.recycleTV);
        textView.setText(crop_protection.black.get(position).title);
    }
}
