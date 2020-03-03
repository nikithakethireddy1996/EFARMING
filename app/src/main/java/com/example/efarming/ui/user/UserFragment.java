package com.example.efarming.ui.user;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.efarming.R;
import com.example.efarming.UserCropInfoActivity;
import com.example.efarming.ViewInfoActivity;

import static com.example.efarming.R.layout.fragment_user;

public class UserFragment extends Fragment {
    Spinner dropdown = null;
    private UserViewModel userViewModel;
    Button newcropBTN;
    Button infoBTN;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userViewModel =
                ViewModelProviders.of(this).get(UserViewModel.class);
        View root = inflater.inflate(fragment_user, container, false);
        dropdown = (Spinner) root.findViewById(R.id.spinner);
        initspinnerfooter();
        newcropBTN = root.findViewById(R.id.newcropBTN);
        infoBTN=root.findViewById(R.id.infoBTN);

        infoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getContext(), ViewInfoActivity.class);
                startActivity(in);
            }
        });
        newcropBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nw = new Intent(getActivity(), UserCropInfoActivity.class);
                startActivity(nw);

            }
        });


        userViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;

    }

    private void initspinnerfooter() {
        String[] items = new String[]{
                "Choose crop", "sugarcane", "cotton", "wheat", "paddy"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
}

