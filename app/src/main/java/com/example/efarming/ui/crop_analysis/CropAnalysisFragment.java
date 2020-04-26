package com.example.efarming.ui.crop_analysis;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.efarming.CA_RecucleView_Page_Activity;
import com.example.efarming.MainActivity;
import com.example.efarming.R;
import com.example.efarming.ui.crop_analysis.CropAnalysisViewModel;

public class CropAnalysisFragment extends Fragment {
    Button blackBTN,redBTN,sandyBTN;
    private CropAnalysisViewModel cropAnalysisViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        OnBackPressedCallback callback = new OnBackPressedCallback(
                true
        ) {
            @Override
            public void handleOnBackPressed() {
                Intent ini = new Intent(getActivity(), MainActivity.class);
                startActivity(ini);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
        cropAnalysisViewModel =
                ViewModelProviders.of(this).get(CropAnalysisViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crop_analysis, container, false);
        blackBTN = root.findViewById(R.id.BlackSoilBTN);
        redBTN = root.findViewById(R.id.RedSoilBTN);
        sandyBTN = root.findViewById(R.id.SandySoilBTN);

        blackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini1 = new Intent(getActivity(), CA_RecucleView_Page_Activity.class);
                startActivity(ini1);
            }
        });

        redBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini1 = new Intent(getActivity(), CA_RecucleView_Page_Activity.class);
                startActivity(ini1);
            }
        });

        sandyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini1 = new Intent(getActivity(), CA_RecucleView_Page_Activity.class);
                startActivity(ini1);
            }
        });
        return root;
    }
}