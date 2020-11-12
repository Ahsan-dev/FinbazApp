package com.example.myfirst;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class OffersFragment extends Fragment {

    private View view;
    private Toolbar toolbar;
    private TextView toolTitle;
    private ImageView backBtn;





    public OffersFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_offers, container, false);

         toolbar = view.findViewById(R.id.offers_toolbarId);
        toolTitle = view.findViewById(R.id.savings_toolbar_title_id);
        backBtn = view.findViewById(R.id.savings_account_back_button);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolTitle.setText("Get Offers");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),HomeActivity.class));
            }
        });


         return view;
    }
}