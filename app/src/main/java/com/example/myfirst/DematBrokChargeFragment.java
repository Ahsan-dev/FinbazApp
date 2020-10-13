package com.example.myfirst;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DematBrokChargeFragment extends Fragment {

    private TextView chargeTitleText;
    private View view;
    private String chargeCompanyName;
    private RecyclerView chargeRecycler;
    private List<String> chargeDetailsList;

    public DematBrokChargeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_demat_brok_charge, container, false);

        chargeCompanyName = getArguments().getString("companyName");

        chargeTitleText = view.findViewById(R.id.demat_details_brok_charge_title_id);
        chargeRecycler = view.findViewById(R.id.demat_details_brok_charge_recyclerId);
        chargeDetailsList = new ArrayList<>();

        if(chargeCompanyName.equals("upstox")){

            chargeTitleText.setText(R.string.upstox_charge);
            chargeTitleText.setTypeface(null,Typeface.NORMAL);

        }
        if(chargeCompanyName.equals("angelBroking")){

            chargeTitleText.setText(R.string.angel_broking_charge_title);
            chargeDetailsList.addAll(Arrays.asList(getResources().getStringArray(R.array.angel_broking_charge_array)));

        }
        if(chargeCompanyName.equals("icici")){

            chargeTitleText.setText(R.string.icici_charges);
            chargeTitleText.setTypeface(null,Typeface.NORMAL);

        }
        if(chargeCompanyName.equals("5paisa")){

            chargeTitleText.setText(R.string.five_pasisa_charge);
            chargeTitleText.setTypeface(null,Typeface.NORMAL);


        }
        if(chargeCompanyName.equals("iifl")){

            chargeTitleText.setText(R.string.iifl_charge);
            chargeTitleText.setTypeface(null,Typeface.NORMAL);

        }
        if(chargeCompanyName.equals("sharekhan")){

            chargeTitleText.setText(R.string.sharekhan_charge);
            chargeTitleText.setTypeface(null,Typeface.NORMAL);

        }

        CustomListItemAdapter adapter = new CustomListItemAdapter(chargeDetailsList,view.getContext());
        chargeRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        chargeRecycler.setAdapter(adapter);



        return view;


    }
}