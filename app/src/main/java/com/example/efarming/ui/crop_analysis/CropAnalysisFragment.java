package com.example.efarming.ui.crop_analysis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.efarming.R;

public class CropAnalysisFragment extends Fragment {

    private CropAnalysisViewModel cropAnalysisViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cropAnalysisViewModel =
                ViewModelProviders.of(this).get(CropAnalysisViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crop_analysis, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        cropAnalysisViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}