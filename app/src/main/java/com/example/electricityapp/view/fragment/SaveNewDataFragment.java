package com.example.electricityapp.view.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.example.electricityapp.R;
import com.example.electricityapp.data.model.Statistics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SaveNewDataFragment extends Fragment {
    EditText idNumber , idReading;
    Button saveBTN ;
    RadioGroup group;
    RadioButton radioButton;
    String currentDate , data ;
    private DatabaseReference databaseReference ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_save_new_data, container, false);
        idNumber = view.findViewById(R.id.idNumber_ET_SaveNewDataFragment);
        idReading = view.findViewById(R.id.readingNumber_ET_SaveNewDataFragment);
        group = view.findViewById(R.id.radioGroup_SaveNewDataFragment);
        saveBTN = view.findViewById(R.id.save_BTN_SaveNewDataFragment);

        // get Date Now
        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioButtonId = group.getCheckedRadioButtonId();
                radioButton = view.findViewById(radioButtonId);
                Toast.makeText(getContext(), currentDate , Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "" + radioButton.getText() , Toast.LENGTH_SHORT).show();
                saveStatistics();
            }
        });

        return view;
    }

    private void saveStatistics(){
        String number = idNumber.getText().toString();
        String reading = idReading.getText().toString();
        String date = currentDate.toString();
        Statistics statistics = new Statistics(number , reading , date);
        String company = "فواتير " + radioButton.getText().toString();

        databaseReference = FirebaseDatabase.getInstance().getReference(company);
        databaseReference.child(number).setValue(statistics);
    }
}