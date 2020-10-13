package com.example.myfirst;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutSavBankFragment extends Fragment {

    private View view;
    private TextView aboutText, mbValue, irValue;
    //private String bankName ;




    public AboutSavBankFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about_sav_bank, container, false);


        String bankName = getArguments().getString("bankNameAbout");

        aboutText = view.findViewById(R.id.sav_bank_about_txt);
        mbValue = view.findViewById(R.id.sav_bank_about_mb_value_id);
        irValue = view.findViewById(R.id.sav_bank_about_ir_value_id);

        if(bankName=="indusind"){

            aboutText.setText(getResources().getString(R.string.indusind_about_string));
            mbValue.setText("₹ 0");
            irValue.setText("upto 6%");

        }
        if(bankName=="kotak"){

            aboutText.setText(getResources().getString(R.string.kotak_about_string));
            mbValue.setText("₹ 0");
            irValue.setText("upto 4%");

        }
        if(bankName=="digibank"){

            aboutText.setText(getResources().getString(R.string.digibank_about_string));
            mbValue.setText("₹ 0");
            irValue.setText("upto 5%");

        }
        if(bankName=="rbl"){

            aboutText.setText(getResources().getString(R.string.rbl_about_string));
            mbValue.setText("₹ 2,000");
            irValue.setText("upto 6.75%");

        }
        if(bankName=="idfc"){

            aboutText.setText(getResources().getString(R.string.idfc_about_string));
            mbValue.setText("₹ 10,000 - 25,000");
            irValue.setText("upto 7%");

        }


        return view;
    }
}