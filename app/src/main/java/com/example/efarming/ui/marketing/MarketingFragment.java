package com.example.efarming.ui.marketing;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.efarming.LoginActivity;
import com.example.efarming.MainActivity;
import com.example.efarming.R;
import com.example.efarming.crop_fruits;

import java.util.ArrayList;

public class MarketingFragment extends Fragment {
    Button btnFruits, btnVeggie;
    private MarketingViewModel marketingViewModel;
    public static String x = "";
    public static ArrayList<String> spinItem;
    public static ArrayAdapter<String> adapter;

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
        marketingViewModel =
                ViewModelProviders.of(this).get(MarketingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_marketing, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        btnFruits = root.findViewById(R.id.btnFruits);
        btnFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!LoginActivity.isUserLogin) {
                    Toast.makeText(getContext(), "Please login", Toast.LENGTH_LONG).show();
                    return;
                }
                x = "Fruit Type";
                spinItem = new ArrayList<>();
                spinItem.add("Select");
                spinItem.add("Grapes");
                spinItem.add("Apples");
                spinItem.add("Bananas");
                spinItem.add("oranges");
                spinItem.add("mangoes");
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, spinItem);
                Intent intent1 = new Intent(getActivity(), crop_fruits.class);
                startActivity(intent1);
            }
        });
        btnVeggie = root.findViewById(R.id.btnVeggie);
        btnVeggie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                if (!LoginActivity.isUserLogin) {
                    Toast.makeText(getContext(), "Please login", Toast.LENGTH_LONG).show();
                    return;
                }
                x = "Vegetable Type";
                spinItem = new ArrayList<>();
                spinItem.add("Select");
                spinItem.add("carrot");
                spinItem.add("potato");
                spinItem.add("cucumber");
                spinItem.add("spinach");
                spinItem.add("capsicum");
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, spinItem);
                Intent int1 = new Intent(getActivity(), crop_fruits.class);
                startActivity(int1);
            }
        });
        marketingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


}