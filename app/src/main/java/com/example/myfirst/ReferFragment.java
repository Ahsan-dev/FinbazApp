package com.example.myfirst;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ReferFragment extends Fragment {


    private View view;
    private TextView referralCodeText;
    private TextView shareBtn;
    private String referralCode;



    public ReferFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_refer, container, false);

        referralCodeText = view.findViewById(R.id.refer_friend_referral_code_value);
        shareBtn = view.findViewById(R.id.refer_friend_share_txt_btn);


        return view;
    }
}