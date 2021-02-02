package com.example.electricityapp.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.electricityapp.R;
import com.example.electricityapp.data.model.Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddMemberFragment extends Fragment {
    EditText idNumberET , idNameET , idRegionET , idHomeET , idFloorET;
    Button saveBTN;
    RadioGroup mGroup1 ;
    RadioButton radioButton ;
    int id;
    private DatabaseReference databaseReference;

    public AddMemberFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_member, container, false);

        idNumberET = view.findViewById(R.id.idNumber_ET_AddMemberFragment);
        idNameET = view.findViewById(R.id.idName_ET_AddMemberFragment);
        idRegionET = view.findViewById(R.id.idRegion_ET_AddMemberFragment);
        idHomeET = view.findViewById(R.id.idHome_ET_AddMemberFragment);
        idFloorET = view.findViewById(R.id.idFloor_ET_AddMemberFragment);
        mGroup1 = view.findViewById(R.id.radioGroup);
        saveBTN = view.findViewById(R.id.save_BTN_AddMemberFragment);

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = mGroup1.getCheckedRadioButtonId();
                radioButton = view.findViewById(radioId);
                Toast.makeText(getContext(), "" + radioButton.getText(), Toast.LENGTH_SHORT).show();
                uploadDataToFirebase();
            }
        });

        return view;
    }

    private void uploadDataToFirebase(){
        String idNumber = idNumberET.getText().toString();
        String idCompany = radioButton.getText().toString();
        String idName = idNameET.getText().toString();
        String idRegion = idRegionET.getText().toString();
        String idHome = idHomeET.getText().toString();
        String idFloor = idFloorET.getText().toString();
        Profile profile = new Profile(idNumber , idCompany , idName , idRegion , idHome , idFloor , "احصائيات");
        databaseReference = FirebaseDatabase.getInstance().getReference(idCompany);
        databaseReference.child(idNumber).setValue(profile);
    }
}