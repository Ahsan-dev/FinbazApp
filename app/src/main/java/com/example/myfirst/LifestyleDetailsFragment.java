package com.example.myfirst;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class LifestyleDetailsFragment extends Fragment {

    private TextView residenceTypeTxt, maritalStatusTxt, vehicleTypeTxt;
    private Spinner residenceTypeSpinner, maritalStatusSpinner, vehicleTypeSpinner;
    private Button submitBtn;
    private TextView lifestyleEdtReqTxtBtn;
    private View view;
    private String[] residenceTypeArray, maritalStatusArray, vehicleTypeArray;
    private ArrayAdapter<String> residenceTypeAdapter, maritalStatusAdapter, vehicleTypeAdapter;
    private String residenceType, maritalStatus, vehicleType;
    private String lifestyleEdtApproval = "approved";


    public LifestyleDetailsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lifestyle_details, container, false);

        residenceTypeTxt = view.findViewById(R.id.lifestyle_detail_residence_type_txt_id);
        residenceTypeSpinner = view.findViewById(R.id.lifestyle_detail_residence_type_spinner_id);
        maritalStatusTxt = view.findViewById(R.id.lifestyle_detail_marital_status_txt_id);
        maritalStatusSpinner = view.findViewById(R.id.lifestyle_detail_marital_status_spinner_id);
        vehicleTypeTxt = view.findViewById(R.id.lifestyle_detail_vehicle_type_txt_id);
        vehicleTypeSpinner = view.findViewById(R.id.lifestyle_detail_vehicle_type_spinner_id);
        submitBtn = view.findViewById(R.id.lifestyle_detail_submit_btn_id);
        lifestyleEdtReqTxtBtn = view.findViewById(R.id.lifestyle_detail_edt_request_txt_id);


        residenceTypeArray = view.getResources().getStringArray(R.array.residence_type_array);
        maritalStatusArray = view.getResources().getStringArray(R.array.marital_status_array);
        vehicleTypeArray = view.getResources().getStringArray(R.array.vehicle_type_array);

        residenceTypeMaker();
        maritalStatusMaker();
        vehicleTypeMaker();



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if(lifestyleEdtApproval == "approved"){

            lifestyleEdtReqTxtBtn.setVisibility(View.GONE);
            residenceTypeSpinner.setVisibility(View.VISIBLE);
            maritalStatusSpinner.setVisibility(View.VISIBLE);
            vehicleTypeSpinner.setVisibility(View.VISIBLE);
            submitBtn.setVisibility(View.VISIBLE);

        }else {

            lifestyleEdtReqTxtBtn.setVisibility(View.VISIBLE);
            residenceTypeSpinner.setVisibility(View.GONE);
            maritalStatusSpinner.setVisibility(View.GONE);
            vehicleTypeSpinner.setVisibility(View.GONE);
            submitBtn.setVisibility(View.GONE);

        }

    }

    private void residenceTypeMaker() {
        residenceTypeAdapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,residenceTypeArray);
        residenceTypeSpinner.setAdapter(residenceTypeAdapter);
        residenceType =  residenceTypeSpinner.getSelectedItem().toString();
    }

    private void maritalStatusMaker() {
        maritalStatusAdapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,maritalStatusArray);
        maritalStatusSpinner.setAdapter(maritalStatusAdapter);
        maritalStatus =  maritalStatusSpinner.getSelectedItem().toString();
    }

    private void vehicleTypeMaker() {
        vehicleTypeAdapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,vehicleTypeArray);
        vehicleTypeSpinner.setAdapter(vehicleTypeAdapter);
        vehicleType =  vehicleTypeSpinner.getSelectedItem().toString();
    }
}