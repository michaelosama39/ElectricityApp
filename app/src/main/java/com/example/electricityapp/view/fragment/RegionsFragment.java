package com.example.electricityapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.electricityapp.R;
import com.example.electricityapp.view.activity.HomeActivity;

public class RegionsFragment extends Fragment implements View.OnClickListener {
    Button alex_btn , elQana_btn , north_delta_btn ,
            south_delta_btn , middle_egypt_btn , north_cairo_btn ,
            beheira_btn , south_cairo_btn ;

    public RegionsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_regions, container, false);
        alex_btn = view.findViewById(R.id.alex_btn_regions);
        elQana_btn = view.findViewById(R.id.elQana_btn_regions);
        north_delta_btn = view.findViewById(R.id.north_delta_btn_regions);
        south_delta_btn = view.findViewById(R.id.south_delta_btn_regions);
        middle_egypt_btn = view.findViewById(R.id.middle_egypt_btn_regions);
        north_cairo_btn = view.findViewById(R.id.north_cairo_btn_regions);
        beheira_btn = view.findViewById(R.id.beheira_btn_regions);
        south_cairo_btn = view.findViewById(R.id.south_cairo_btn_regions);

        alex_btn.setOnClickListener(this);
        elQana_btn.setOnClickListener(this);
        north_delta_btn.setOnClickListener(this);
        south_delta_btn.setOnClickListener(this);
        middle_egypt_btn.setOnClickListener(this);
        north_delta_btn.setOnClickListener(this);
        beheira_btn.setOnClickListener(this);
        south_cairo_btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.alex_btn_regions:
                // set data
                Bundle bundle = new Bundle();
                bundle.putString("data1" , "شركة الاسكندرية لتوزيع الكهـرباء");

                // open new fregment
                Intent intent1 = new Intent(getContext() , HomeActivity.class);
                startActivity(intent1);
                return;

            case R.id.elQana_btn_regions:
                // set data
                Bundle bundle2 = new Bundle();
                bundle2.putString("data2" , "شركـة القنـاه لتوزيـع الكهـرباء");

                //open new fregment
                Intent intent2 = new Intent(getContext() , HomeActivity.class);
                startActivity(intent2);
                return;

            case R.id.north_delta_btn_regions:
                // set data
                Bundle bundle3 = new Bundle();
                bundle3.putString("data3" , "شركة شمال الدلتا لتوزيع الكهرباء");

                //open new fregment
                Intent intent3 = new Intent(getContext() , HomeActivity.class);
                startActivity(intent3);
                return;

            case R.id.south_delta_btn_regions:
                // set data
                Bundle bundle4 = new Bundle();
                bundle4.putString("data4" , "شركة جنوب الدلتا لتوزيع الكهرباء");

                //open new fregment
                Intent intent4 = new Intent(getContext() , HomeActivity.class);
                startActivity(intent4);
                return;

            case R.id.middle_egypt_btn_regions:
                // set data
                Bundle bundle5 = new Bundle();
                bundle5.putString("data5" , "شركة مصر الوسطى لتوزيع الكهرباء");

                //open new fregment
                Intent intent5 = new Intent(getContext() , HomeActivity.class);
                startActivity(intent5);
                return;

            case R.id.north_cairo_btn_regions:
                // set data
                Bundle bundle6 = new Bundle();
                bundle6.putString("data6" , "شركة شمال القاهرة لتوزيع الكهرباء");

                //open new fregment
                Intent intent6 = new Intent(getContext() , HomeActivity.class);
                startActivity(intent6);
                return;

            case R.id.beheira_btn_regions:
                // set data
                Bundle bundle7 = new Bundle();
                bundle7.putString("data7" , "شركة البحيرة لتوزيع الكهرباء");

                //open new fregment
                Intent intent7 = new Intent(getContext() , HomeActivity.class);
                startActivity(intent7);
                return;

            case R.id.south_cairo_btn_regions:
                // set data
                Bundle bundle8 = new Bundle();
                bundle8.putString("data8" , "شركة جنوب القاهرة لتوزيع الكهرباء");

                //open new fregment
                Intent intent8 = new Intent(getContext() , HomeActivity.class);
                startActivity(intent8);
                return;
        }
    }
}