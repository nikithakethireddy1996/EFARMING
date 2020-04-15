package com.example.efarming.ui.help;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.efarming.MainActivity;
import com.example.efarming.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class HelpFragment extends Fragment {

    private HelpViewModel helpViewModel;
    Button dropdown;

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
        helpViewModel = ViewModelProviders.of(this).get(HelpViewModel.class);
        View root = inflater.inflate(R.layout.fragment_help, container, false);
        //final TextView textView = root.findViewById(R.id.text_tools);

        dropdown = (Button) root.findViewById(R.id.CallBTN);
        dropdown.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               buttonPressed(v);
           }
               /* Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:6108361856"));

                if (ActivityCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }*/
               // startActivity(callIntent);
               public void buttonPressed(View v) {
                   Button clicked = (Button) v;
                   if(clicked.getId() == R.id.CallBTN) {
                       Uri number = Uri.parse("tel:+16108361856");
                       Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                       startActivity(callIntent);
                   }
            }
        });

        helpViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //  textView.setText(s);
            }
        });
        return root;
    }
}

