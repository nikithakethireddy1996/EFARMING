package com.example.efarming.ui.user;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
import com.example.efarming.UserCropInfoActivity;
import com.example.efarming.ViewInfoActivity;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import static com.example.efarming.R.layout.fragment_user;

public class UserFragment extends Fragment {
    Spinner dropdown = null;
    private UserViewModel userViewModel;
    Button newcropBTN;
    Button infoBTN;
    FirebaseFirestore firebaseFirestore;
    private ArrayList<String> spinItem1;
    private ArrayAdapter<String> adapter1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        firebaseFirestore = FirebaseFirestore.getInstance();
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
        userViewModel =
                ViewModelProviders.of(this).get(UserViewModel.class);
        View root = inflater.inflate(fragment_user, container, false);
        dropdown = (Spinner) root.findViewById(R.id.spinner);
        getDta1();
        newcropBTN = root.findViewById(R.id.newcropBTN);
        infoBTN=root.findViewById(R.id.infoBTN);
        infoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!LoginActivity.isUserLogin) {
                    Toast.makeText(getContext(), "Please login", Toast.LENGTH_LONG).show();
                    return;
                }
                getDta();
            }
        });
        newcropBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!LoginActivity.isUserLogin) {
                    Toast.makeText(getContext(), "Please login", Toast.LENGTH_LONG).show();
                    return;
                }
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


    public void getDta(){
        firebaseFirestore.collection("cropsInfo").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e != null) {
                    Log.d("UserFragment", "Error:" + e.getMessage());
                    return;
                } else {
                    for (DocumentChange documentChange : documentSnapshots.getDocumentChanges()) {
                        if (dropdown.getSelectedItem().toString().equalsIgnoreCase(documentChange.getDocument().getData().get("Name").toString())){
                            Intent in=new Intent(getContext(), ViewInfoActivity.class);
                            in.putExtra("drop_down_amspt",documentChange.getDocument().getData().get("Amount spent").toString());
                            in.putExtra("drop_down_cname",documentChange.getDocument().getData().get("Name").toString());
                            in.putExtra("drop_down_pr",documentChange.getDocument().getData().get("Profit").toString());
                            in.putExtra("drop_down_qn",documentChange.getDocument().getData().get("Quantity").toString());
                            in.putExtra("drop_down_yrs",documentChange.getDocument().getData().get("Year").toString());
                            startActivity(in);
                        }
                    }
                }
            }
        });
    }
    public void getDta1(){
        firebaseFirestore.collection("cropsInfo").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e != null) {
                    Log.d("UserCropInfoActivity", "Error:" + e.getMessage());
                    return;
                } else {
                    spinItem1 = new ArrayList<>();
                    spinItem1.add("select");
                    for (DocumentChange documentChange : documentSnapshots.getDocumentChanges()) {
                        spinItem1.add(documentChange.getDocument().getData().get("Name").toString());
                    }
                    adapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, spinItem1);
                    dropdown.setAdapter(adapter1);
                }
            }
        });
    }
}

