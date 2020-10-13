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


public class CreditCardFeaturesFragment extends Fragment {

    private TextView cardAFeaturesTitleText;
    private View view;
    private String cardName;
    private RecyclerView cardFeaturesRecycler;
    private List<String> cardFeaturesList;


    public CreditCardFeaturesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_credit_card_features, container, false);

        cardName = getArguments().getString("cardName");

        cardAFeaturesTitleText = view.findViewById(R.id.credit_card_details_features_title_id);
        cardFeaturesRecycler = view.findViewById(R.id.credit_card_details_features_recyclerId);
        cardFeaturesList = new ArrayList<>();

        if(cardName.equals("saveSbi")){

            cardAFeaturesTitleText.setVisibility(View.GONE);
            cardFeaturesList.addAll(Arrays.asList(getResources().getStringArray(R.array.simply_save_features_array)));

        }
        if(cardName.equals("clickSbi")){

            cardAFeaturesTitleText.setVisibility(View.GONE);
            cardFeaturesList.addAll(Arrays.asList(getResources().getStringArray(R.array.simply_click_features_array)));

        }
        if(cardName.equals("rblShop")){

            cardAFeaturesTitleText.setVisibility(View.GONE);
            cardFeaturesList.addAll(Arrays.asList(getResources().getStringArray(R.array.shop_rbl_features_array)));

        }

        CustomListItemAdapter adapter = new CustomListItemAdapter(cardFeaturesList,view.getContext());
        cardFeaturesRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        cardFeaturesRecycler.setAdapter(adapter);



        return view;


    }
}