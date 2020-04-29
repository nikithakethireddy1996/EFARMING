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
import com.example.efarming.soilInfo;

public class CropAnalysisFragment extends Fragment {
    Button blackBTN,redBTN,sandyBTN;
    private CropAnalysisViewModel cropAnalysisViewModel;
    Intent ini1;

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
        ini1 = new Intent(getActivity(), soilInfo.class);
        blackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ini1.putExtra("soil_display_data",
                        "The organic and inorganic materials on the surface of the Earth that provides the medium for plant growth\n\n\nCrops suitable to grow: \n\nCotton, maize, jowar, linseed, Virginia tobacco, castor, sunflower, and millets are some of the major crops grown on the black soils.");
                startActivity(ini1);
            }
        });

        redBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ini1.putExtra("soil_display_data","Red soil is a type of soil that develops in a warm, temperate, moist climate under deciduous or mixed forest, having thin organic and organic-mineral layers overlying a yellowish-brown leached layer resting on an illuvium red layer.\n\n\nCrops suitable to grow: \n\nSuitable for growing cotton , wheat, pulses, tobacco,jowar,linseed,millet,potato and fruits with better irrigation.");
                startActivity(ini1);
            }
        });

        sandyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ini1.putExtra("soil_display_data","Sandy Soil is a soil with a high percentage of sand, or large soil particles.  It mainly consists of rock particles such as limestone, shale, granite and quartz. Sandy Soil has a low percentage of organic material. Water travels through sandy soil very easily, so nutrients leach out quickly.\n\n\nCrops suitable to grow: \n\nSuitable for growing Lettuce, strawberries, peppers, corn, squash, zucchini, collard greens and tomatoes are grown commercially in sandy soils");
                startActivity(ini1);
            }
        });
        return root;
    }
}