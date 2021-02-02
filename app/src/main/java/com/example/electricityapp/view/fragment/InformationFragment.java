package com.example.electricityapp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electricityapp.R;
import com.example.electricityapp.data.model.Information;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class InformationFragment extends Fragment {
    EditText idNumberET;
    Spinner companySPN;
    Button showBTN;
    ListView listView;
    String[] companyList;
    String company , idNumber , currentDate;
    DatabaseReference database;
    Information information;
    ArrayList<Information> list;
    ArrayAdapter<Information> adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        idNumberET = view.findViewById(R.id.idNumber_ET_InformationFragment);
        companySPN = view.findViewById(R.id.company_SPN_InformationFragment);
        listView = view.findViewById(R.id.listView);
        showBTN = view.findViewById(R.id.show_BTN_InformationFragment);
        list = new ArrayList<>();

        // set data to spinner
        companyList = getResources().getStringArray(R.array.company);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(getContext() , R.layout.style_spinner , companyList);
        companySPN.setAdapter(arrayAdapter);

        // listner spinner
        companySPN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                company = "فواتير " + parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), company , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // get id number from EditView
        idNumber = idNumberET.getText().toString();

        information = new Information();
        // reading from database
        showBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance().getReference().child(company);
//                DatabaseReference myRef = database.child(company);

                database.child(idNumber).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        information = dataSnapshot.getValue(Information.class);
                        list.add(information);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {}

                });
                adapter = new ArrayAdapter<Information>(getContext(), android.R.layout.activity_list_item ,list);
                listView.setAdapter(adapter);
            }
        });
        return view;
    }
}