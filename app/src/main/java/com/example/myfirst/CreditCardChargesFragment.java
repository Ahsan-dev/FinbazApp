package com.example.myfirst;

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

public class CreditCardChargesFragment extends Fragment {

    private TextView cardChargesTitleText;
    private View view;
    private String cardName;
    private RecyclerView cardChargesRecycler;
    private List<String> cardChargesList;



    public CreditCardChargesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_credit_card_charges, container, false);

        cardName = getArguments().getString("cardName");

        cardChargesTitleText = view.findViewById(R.id.credit_card_details_charges_title_id);
        cardChargesRecycler = view.findViewById(R.id.credit_card_details_charges_recyclerId);
        cardChargesList = new ArrayList<>();

        if(cardName.equals("saveSbi")){

            cardChargesTitleText.setVisibility(View.GONE);
            cardChargesList.addAll(Arrays.asList(getResources().getStringArray(R.array.simply_save_charge_array)));

        }
        if(cardName.equals("clickSbi")){

            cardChargesTitleText.setVisibility(View.GONE);
            cardChargesList.addAll(Arrays.asList(getResources().getStringArray(R.array.simply_click_charges_array)));

        }
        if(cardName.equals("rblShop")){

            cardChargesTitleText.setVisibility(View.GONE);
            cardChargesList.addAll(Arrays.asList(getResources().getStringArray(R.array.shop_rbl_charges_array)));

        }

        CustomListItemAdapter adapter = new CustomListItemAdapter(cardChargesList,view.getContext());
        cardChargesRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        cardChargesRecycler.setAdapter(adapter);



        return view;



    }
}