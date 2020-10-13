package com.example.myfirst;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class RBLBankFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Fragment fragment;
    private RelativeLayout frameRelative;
    private TextView aboutBtn, docReqBtn, prodFeatureBtn, bankLocateBtn;
    private AboutSavBankFragment aboutSavBankFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_r_b_l_bank, container, false);

        if(savedInstanceState == null){

            Bundle b = new Bundle();
            b.putString("bankNameAbout","rbl");
            aboutSavBankFragment= new AboutSavBankFragment();
            aboutSavBankFragment.setArguments(b);

            getChildFragmentManager().beginTransaction().replace(R.id.rblbank_savings_bank_details_functions_details_relative,aboutSavBankFragment).commit();

        }else {

            getChildFragmentManager().beginTransaction().replace(R.id.rblbank_savings_bank_details_functions_details_relative, fragment).commit();

        }

        aboutBtn = view.findViewById(R.id.rblbank_about_txt_btn);
        docReqBtn = view.findViewById(R.id.rblbank_document_req_txt_btn);
        prodFeatureBtn = view.findViewById(R.id.rblbank_prod_features_txt_btn);
        bankLocateBtn = view.findViewById(R.id.rblbank_bank_location_txt_btn);

        aboutBtn.setOnClickListener(this);
        docReqBtn.setOnClickListener(this);
        prodFeatureBtn.setOnClickListener(this);
        bankLocateBtn.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        fragment = null;

        if(view.getId()==R.id.rblbank_about_txt_btn){
            fragment = new AboutSavBankFragment();
            aboutBtn.setBackgroundResource(R.drawable.back_phone_four);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.white));
            docReqBtn.setBackgroundResource(R.drawable.back_phone_two);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.black));
            prodFeatureBtn.setBackgroundResource(R.drawable.back_phone_two);
            prodFeatureBtn.setTextColor(getResources().getColor(android.R.color.black));
            bankLocateBtn.setBackgroundResource(R.drawable.back_phone_two);
            bankLocateBtn.setTextColor(getResources().getColor(android.R.color.black));
            Bundle b = new Bundle();
            b.putString("bankNameAbout","rbl");
            fragment.setArguments(b);

        }
        if(view.getId()==R.id.rblbank_document_req_txt_btn){
            fragment = new SavBankDocReqFragment();
            docReqBtn.setBackgroundResource(R.drawable.back_phone_four);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.white));
            aboutBtn.setBackgroundResource(R.drawable.back_phone_two);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.black));
            prodFeatureBtn.setBackgroundResource(R.drawable.back_phone_two);
            prodFeatureBtn.setTextColor(getResources().getColor(android.R.color.black));
            bankLocateBtn.setBackgroundResource(R.drawable.back_phone_two);
            bankLocateBtn.setTextColor(getResources().getColor(android.R.color.black));
            Bundle b = new Bundle();
            b.putString("bankName","rbl");
            fragment.setArguments(b);

        }
        if(view.getId()==R.id.rblbank_prod_features_txt_btn){
            fragment = new SavBankProdFeaturesFragment();
            prodFeatureBtn.setBackgroundResource(R.drawable.back_phone_four);
            prodFeatureBtn.setTextColor(getResources().getColor(android.R.color.white));
            docReqBtn.setBackgroundResource(R.drawable.back_phone_two);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.black));
            aboutBtn.setBackgroundResource(R.drawable.back_phone_two);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.black));
            bankLocateBtn.setBackgroundResource(R.drawable.back_phone_two);
            bankLocateBtn.setTextColor(getResources().getColor(android.R.color.black));
            Bundle b = new Bundle();
            b.putString("bankName","rbl");
            fragment.setArguments(b);

        }
        if(view.getId()==R.id.rblbank_bank_location_txt_btn){
            fragment = new SavBankLocateFragment();
            bankLocateBtn.setBackgroundResource(R.drawable.back_phone_four);
            bankLocateBtn.setTextColor(getResources().getColor(android.R.color.white));
            docReqBtn.setBackgroundResource(R.drawable.back_phone_two);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.black));
            prodFeatureBtn.setBackgroundResource(R.drawable.back_phone_two);
            prodFeatureBtn.setTextColor(getResources().getColor(android.R.color.black));
            aboutBtn.setBackgroundResource(R.drawable.back_phone_two);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.black));
            Bundle b = new Bundle();
            b.putString("bankName","rbl");
            fragment.setArguments(b);
        }


        getChildFragmentManager().beginTransaction().replace(R.id.rblbank_savings_bank_details_functions_details_relative,fragment).commit();

    }



}