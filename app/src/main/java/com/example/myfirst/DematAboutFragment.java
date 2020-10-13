package com.example.myfirst;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DematAboutFragment extends Fragment {

    private TextView aboutText;
    private View view;
    private String companyName;

    public DematAboutFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_demat_about, container, false);

        companyName = getArguments().getString("companyName");

        aboutText = view.findViewById(R.id.demat_details_about_frag_about_txt);

        if(companyName.equals("upstox")){
            aboutText.setText(R.string.upstox_about);
        }
        if(companyName.equals("angelBroking")){
            aboutText.setText(R.string.angel_broking_about);
        }
        if(companyName.equals("icici")){
            aboutText.setText(R.string.icici_about);
        }
        if(companyName.equals("5paisa")){
            aboutText.setText(R.string.five_paisa_about);
        }
        if(companyName.equals("iifl")){
            aboutText.setText(R.string.iifl_about);
        }
        if(companyName.equals("sharekhan")){
            aboutText.setText(R.string.sharekhan_about);
        }





        return view;
    }
}