package com.example.efarming.ui.marketing;

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

import com.example.efarming.MainActivity;
import com.example.efarming.R;
import com.example.efarming.SearchActivity;
import com.example.efarming.ui.user.UserFragment;
import com.example.efarming.ui.user.UserViewModel;

public class MarketingFragment extends Fragment {
    Button btnsrch;
    private MarketingViewModel marketingViewModel;

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
        btnsrch = root.findViewById(R.id.btnsrch);
        btnsrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
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